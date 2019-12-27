public class FindTheDuplicateNumber{

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {2,2,2,2,2}));
    }

    public int findDuplicate(int[] nums) {
        int max = nums.length;
        int min = 1;
        int mid = (max + min) / 2;
        int count = 0;
        int testCount = 0;

        while (min < max) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid && nums[i] >= min)
                    count++;
                if(nums[i] == mid)
                    testCount++;
            }
            if(testCount >= 2)
                return mid;
            if(count + testCount <= mid - min + 1){
                min = mid + 1;
                mid = (max + min) / 2;
            }else{
                max = mid - 1;
                mid = (max + min) / 2;
            }
            count = 0;
            testCount = 0;
        }

        return min;
    }
}
