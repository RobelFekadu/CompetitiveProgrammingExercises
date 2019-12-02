public class SortArrayByParityII{
    public int[] sortArrayByParityII(int[] A) {
        int oddIndex, evenIndex, length, value;
        length = A.length;
        oddIndex = 1;
        evenIndex = 0;

        int[] finalList = new int[length];

        for(int i = 0; i < length; i++){
            value = A[i];
            if(value % 2 == 0){
                finalList[evenIndex] = value;
                evenIndex = evenIndex + 2;
            }
            else{
                finalList[oddIndex] = value;
                oddIndex = oddIndex + 2;
            }
        }

        return finalList;
    }
}