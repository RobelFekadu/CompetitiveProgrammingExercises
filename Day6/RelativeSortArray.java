import java.util.*;
import java.util.stream.Collectors;

public class RelativeSortArray{
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
        ArrayList<Integer> finalList = new ArrayList<>();
        int length = arr2.length;

        for(int i = 0; i < length; i++){
            int value = arr2[i];
            while (arrayList.contains(value)) {
                int index = arrayList.indexOf(value);
                arrayList.remove(index);
                finalList.add(value);
            }
        }

        Collections.sort(arrayList);
        finalList.addAll(arrayList);
        int[] arr = finalList.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}