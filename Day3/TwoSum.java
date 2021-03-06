public class TwoSum{
    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 2, 9, 4};
        int[] result = twoSum(nums, 8);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}