class Solution {
    int limit;
    
    public int smallestDivisor(int[] nums, int threshold) {
        limit = threshold;
        int left = 1;
        int right = 0;
        
        for(int num: nums){
            right = Math.max(right, num);
        }
        
        while(left <= right) {
            int mid = left + (right-left) / 2;
            
            if(check(nums,mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }   
        }
        
        return left;
    }
    
    private boolean check(int[] nums, double d) {
        int sum = 0; 
        
        for(int num: nums){
            sum += Math.ceil(num/d);
        }
        return sum <= limit;
    }
}