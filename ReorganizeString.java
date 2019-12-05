public class ReorganizeString{
    public static String reorganizeString(String S) {
        if(S.length() == 1)
            return S;
        int count = -1, value = -1;
        int[][] stringArray = new int[S.length()][2];
        char[] stringArr = S.toCharArray();
        Arrays.sort(stringArr);
        for (int i = 0; i < stringArr.length; i++){
            if((int)stringArr[i] != value){
                count++;
                value = (int)stringArr[i];
                stringArray[count] = new int[]{1, value};
            }
            else {
                stringArray[count][0]++;
            }
        }
        sort(stringArray, 0, stringArray.length - 1);

        if( (S.length() % 2 == 0 && stringArray[stringArray.length - 1][0] > S.length()/2) || (S.length() % 2 != 0 && stringArray[stringArray.length - 1][0] > S.length()/2 + 1))
            return "";
        count = 0;
        int oddCount = 1;
        for (int i = stringArr.length - 1; i >= 0 ; i--){
            while (stringArray[i][0] > 0){
                if(count < stringArr.length){
                    stringArr[count] = (char) stringArray[i][1];
                    count += 2;
                }
                else if(oddCount < stringArr.length){
                    stringArr[oddCount] = (char) stringArray[i][1];
                    oddCount += 2;
                }
                stringArray[i][0]--;
            }
            if(count >= stringArr.length && oddCount>= stringArr.length)
                break;
        }

        return new String(stringArr);
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