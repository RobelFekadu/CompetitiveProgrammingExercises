import java.util.*;

public class PancakeSorting{
    public List<Integer> pancakeSort(int[] A) {
        int maxIndex;
        ArrayList<Integer> flipList = new ArrayList<>();
        int count = 0;
        while (true){
            if(A.length - count <= 1)
                break;
            maxIndex = findMaxNumberIndex(A, A.length - count);
            count++;

            if(maxIndex == A.length - count)
                continue;
            if(maxIndex > 0){
                A = flip(A, maxIndex);
                flipList.add(maxIndex + 1);
            }
            A = flip(A, A.length - count);
            flipList.add(A.length - count + 1);

        }

        int c = 0;
        for(int i = 0; i < flipList.size(); i++){
            c += flipList.get(i);
        }
        System.out.println("10 * length: " + A.length * 10 + " sum of flips " + flipList.size());
        return flipList;
    }

    public int[] flip(int[] list, int index){

        for (int i = 0; i <= index/2; i++){
            list = Swap(list,i, index - i);
        }

        return list;
    }

    private int findMaxNumberIndex(int[] A, int maxIndexToSearch){
        int maxIndex = 0;
        for(int i = 1; i < maxIndexToSearch; i++){
            if(A[i] > A[maxIndex] )
                maxIndex = i;
        }
        return maxIndex;
    }

    public int[] Swap(int[] list, int index1, int index2){
        int numAtIndex1 = list[index1];
        list[index1] = list[index2];
        list[index2] = numAtIndex1;
        return list;
    }
}