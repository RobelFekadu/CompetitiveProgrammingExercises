public class LargestPerimeter {
    public int largestPerimeter(int[] A) {
        A = Sort(A);
        
        for (int i = A.length - 1; i >= 2; i--){
            if(A[i - 1] + A[i - 2] > A[i])
                return A[i] + A[i - 1] + A[i - 2];
        }

        return 0;
    }
    private int[] SubList(int[] list, int low, int high){
        if(high <= low)
            return new int[0];
        int[] finalList = new int[high - low];

        for (int i = 0; i < high - low; i++){
            finalList[i] = list[low + i];
        }
        return finalList;
    }

    public int[] Sort(int[] list){
        if(list.length == 1)
            return list;

        int mid = list.length / 2;

        return Merge(Sort(SubList(list, 0, mid)), Sort(SubList(list, mid, list.length)));
    }

    public int[] Merge(int[] left, int[] right){
        int[] temp = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0;

        for (int i = 0; i < right.length + left.length; i++){
            if(leftIndex == left.length){
                temp[i] = right[rightIndex];
                rightIndex++;
            }
            else if(rightIndex == right.length){
                temp[i] = left[leftIndex];
                leftIndex++;
            }
            else if(left[leftIndex] <= right[rightIndex]){
                temp[i] = left[leftIndex];
                leftIndex++;
            }
            else {
                temp[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return temp;
    }

}