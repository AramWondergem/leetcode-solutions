class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int indexWithoutZero = 0;

        while(index < nums.length){
            int c = nums[index];
            nums[indexWithoutZero] = c;
            if(nums[index] != 0){
                indexWithoutZero++;
            }
            index++;
        }

        while( indexWithoutZero < nums.length){
            nums[indexWithoutZero] = 0;
            indexWithoutZero++;
        } 
    }
}