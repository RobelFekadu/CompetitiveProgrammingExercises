import java.util.*;

public class InsertionSort{

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] randomList = insertionSort.getRandomList();
        int[] sortedList = insertionSort.Sort(randomList);
        for (int i = 0; i < randomList.length; i++) {
            System.out.print(sortedList[i] + " ");   
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
        int valueAtIndex1 = list[index1];
        list[index1] = list[index2];
        list[index2] = valueAtIndex1;
        return list;
    }

    public int[] Sort(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j >= 0; j--) {
                if (j >= 1 && list[j] < list[j - 1]) {
                    list = Swap(list, j, j - 1);
                } else break;
            }
        }
        return list;
    }
}