class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0; 
        int right = Integer.MAX_VALUE;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(doCheck(nums, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
        
    }
    
    private boolean doCheck(int[] nums, int k, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if(num > target) {
                return false;
            }
            
            if(sum + num <= target) {
                sum += num;
            } else {
                k--;
                sum = num;
            }
            
        }
        
        return k > 0;
    }
    
    
}