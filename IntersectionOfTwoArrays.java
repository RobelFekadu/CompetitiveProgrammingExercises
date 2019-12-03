import java.util.*;

public class IntersectionOfTwoArrays{

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] inter = intersectionOfTwoArrays.intersection(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 6, 7});
        for(int i = 0; i < inter.length; i++){
            System.out.println(inter[i] + " ");
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int num1, lengthForOne = nums1.length, lengthForTwo = nums2.length;
        ArrayList<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < lengthForOne; i++){
            num1 = nums1[i];
            for (int j = 0; j < lengthForTwo; j++){
                if(num1 == nums2[j]) {
                    if (!finalList.contains(num1)) {
                        finalList.add(num1);
                    }
                }
            }
        }
        return finalList.stream().mapToInt(i -> i).toArray();
    }
}