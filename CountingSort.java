import java.util.*;

class CountingSort{

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] y = countingSort.getRandomList();
        countingSort.Sort(y);
        for(int i =0; i < y.length; i++){
            System.out.println(y[i]);
        }
    }

    int rand = 1000;
    public int[] getRandomList(){
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
        int numAtIndex1 = list[index1];
        list[index1] = list[index2];
        list[index2] = numAtIndex1;
        return list;
    }

    public int[] Sort(int[] list){
        int count = 0;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i <= rand; i++){
            indexMap.put(i, 0);
        }

        for (int i = 0; i < list.length; i++){
            int indexValue = list[i];
            if(indexMap.containsKey(indexValue))
                indexMap.put(indexValue, indexMap.get(indexValue) + 1);
        }

        for (int i = 0; i <= rand; i++){
            int val = indexMap.get(i);
            while (val > 0){
                list[count] = i;
                count++;
                val--;
            }
        }

        return list;
    }
}