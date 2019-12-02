import java.util.*;

public class QuickSort{

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println(quickSort.Sort(quickSort.getRandomList()));
    }

    public ArrayList<Integer> getRandomList(){
        int rand = 10000;
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < rand; i++){
            randomList.add(i);
        }

        Collections.shuffle(randomList);
        return randomList;
    }

    public ArrayList<Integer> Sort(ArrayList<Integer> list){
        if(list.size() <= 1)
            return list;
        int pivot = list.size() - 1;
        int low = 0;
        int leftPivot = 0;

        while (leftPivot != pivot){
            if(list.get(leftPivot) <= list.get(pivot)){
               list = swap(list, low, leftPivot);
               low++;
            }
            leftPivot++;
        }
        List<Integer> left = Sort(new ArrayList<>(list.subList(0, low)));
        List<Integer> right = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        if(low < pivot)
            right = Sort(new ArrayList<>(list.subList(low, pivot)));

        finalList.addAll(left);
        finalList.add(list.get(pivot));
        finalList.addAll(right);
        return finalList;
    }

    private ArrayList<Integer> swap(ArrayList<Integer> list, int index1, int index2){
        if(index1 == index2)
            return list;
        int numberAtIndex1 = list.get(index1);
        int numberAtIndex2 = list.get(index2);

        list.remove(index1);
        list.add(index1, numberAtIndex2);

        list.remove(index2);
        list.add(index2, numberAtIndex1);

        return list;
    }
}