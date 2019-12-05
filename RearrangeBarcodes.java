public class RearrangeBarcodes{
    public static int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length == 1)
            return barcodes;
        int count = -1, value = -1;
        int[][] test = new int[barcodes.length][2];
        Arrays.sort(barcodes);
        for (int i = 0; i < barcodes.length; i++){
            if(barcodes[i] != value){
                count++;
                value = barcodes[i];
                test[count] = new int[]{1, value};
            }
            else {
                test[count][0]++;
            }
        }
        sort(test, 0, test.length - 1);

        count = 0;
        int oddCount = 1;
        for (int i = barcodes.length - 1; i >= 0 ; i--){
            while (test[i][0] > 0){
                if(count < barcodes.length){
                    barcodes[count] = test[i][1];
                    count += 2;
                }
                else if(oddCount < barcodes.length){
                    barcodes[oddCount] = test[i][1];
                    oddCount += 2;
                }
                test[i][0]--;
            }
            if(count >= barcodes.length && oddCount>= barcodes.length)
                break;
        }

        return barcodes;
    }

    static int partition(int arr[][], int low, int high) {
        int pivot = arr[high][0];
        int lowPointer = (low-1); // index of smaller element
        for (int j = low; j < high; j++)
        {
            if (arr[j][0] < pivot)
            {
                lowPointer++;
                int[] temp = arr[lowPointer];
                arr[lowPointer] = arr[j];
                arr[j] = temp;
            }
        }

        int[] temp = arr[lowPointer+1];
        arr[lowPointer+1] = arr[high];
        arr[high] = temp;

        return lowPointer+1;
    }
    static void sort(int arr[][], int low, int high) {
        if (low < high)
        {
            int part = partition(arr, low, high);
            sort(arr, low, part - 1);
            sort(arr, part + 1, high);
        }
    }
}