import java.util.*;

public class MergeSort{
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] randomList = mergeSort.getRandomList();

        int[] sortedList = MergeSort.Sort(randomList);
        for (int i = 0; i < sortedList.length; i++) {
            System.out.println(sortedList[i]);
        }
    }

    public int[] getRandomList(){
        int rand = 10000;
        int[] randomList = new int[rand];
        for (int i = 0; i < rand; i++){
            randomList[i] = i;
        }

        for (int i = 0; i < rand; i++){
            randomList = Swap(randomList, i, new Random().nextInt(rand));
        }
        return randomList;
    }

    public int[] Swap(int[] list, int index1, int index2){
        int numAtindex1 = list[index1];
        list[index1] = list[index2];
        list[index2] = numAtindex1;
        return list;
    }

    private static int[] SubList(int[] list, int low, int high){
        if(high <= low)
            return new int[0];
        int[] finalList = new int[high - low];

        for (int i = 0; i < high - low; i++){
            finalList[i] = list[low + i];
        }
        return finalList;
    }

    public static int[] Sort(int[] list){
        if(list.length == 1)
            return list;

        int mid = list.length / 2;

        return Merge(Sort(SubList(list, 0, mid)), Sort(SubList(list, mid, list.length)));
    }

    private static int[] Merge(int[] left, int[] right){
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