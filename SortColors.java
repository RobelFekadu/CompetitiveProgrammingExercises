public class SortColors{
    public void sortColors(int[] nums) {
        if(nums.length == 1)
            return;
        int indexForRed = 0, lastIndexForWhite = 0, indexForBlue = nums.length - 1;
        int[] tempNums = new int[nums.length];
        System.arraycopy( nums, 0, tempNums, 0, nums.length );
        for (int i = 0; i < nums.length; i++){
            if(tempNums[i] == 0){
                if(nums[indexForRed] == 1){
                    nums[indexForRed] = 0;
                    nums[lastIndexForWhite] = 1;
                }else {
                    nums[indexForRed] = 0;
                }
                indexForRed++;
                lastIndexForWhite++;
            }
            else if(tempNums[i] == 1){
                nums[lastIndexForWhite] = 1;
                lastIndexForWhite++;
            }
            else if(tempNums[i] == 2){
                nums[indexForBlue] = 2;
                indexForBlue--;
            }
        }

    }
}