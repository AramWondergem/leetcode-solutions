class Solution {
    public int pivotIndex(int[] nums) {
        int l = nums.length;
        int[] prefix = new int[l + 1];
        prefix[1] = nums[0];

        for(int i = 2; i < prefix.length; i++){
            prefix[i] = nums[i-1] + prefix[i - 1];
        }

        for(int i = 0; i < prefix.length - 1; i++) {
            if(prefix[i] == prefix[prefix.length - 1] - prefix[i + 1]){
                return i;
            }
        }

        return prefix[prefix.length - 2] == 0 ? l - 1: -1;  
    }
}