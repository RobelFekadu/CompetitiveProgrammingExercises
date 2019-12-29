public class SmallestDivisor {

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[] {1,2,5,9}, 6));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max)
                max = nums[i];
        }

        int mid = (max + min) / 2;
        int finalAns = max;
        
        while (min < max) {
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((double)nums[i] / (double)mid);
            }
            if(sum > threshold){
                min = mid + 1;
                mid = (max + min) / 2;
            }else{
                if(mid <= finalAns)
                    finalAns = mid;
                max = mid - 1;
                mid = (max + min) / 2;
            }
            sum = 0;
        }

        if(max <= finalAns){
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((double)nums[i] / (double)max);
            }
            if(sum <= threshold){
                finalAns = max;
            }
        }

        return finalAns;
    }
}