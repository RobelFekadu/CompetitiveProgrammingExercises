import java.util.*;

public class SelectionSort{

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] randomList = selectionSort.getRandomList();
        int[] sortedList = selectionSort.Sort(randomList);
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

    public int[] Sort(int[] list){
        int minIndex;
        boolean thereIsAChange = false;
        for (int i = 0; i < list.length; i++){
            minIndex = i;
            for (int j = i + 1; j < list.length; j++){
                if(list[j] < list[minIndex]){
                    minIndex = j;
                    thereIsAChange = true;
                }
            }
            if(thereIsAChange) {
                list = Swap(list, i, minIndex);
                thereIsAChange = false;
            }
        }
        return list;
    }

    private int[] Swap(int[] list, int index1, int index2){
        int numberAtIndex1 = list[index1];
        list[index1] = list[index2];
        list[index2] = numberAtIndex1;
        return list;
    }

}