class NumArray {
    int[] prefix;

    public NumArray(int[] nums) {
        prefix = nums;

        for(int i = 1; i < nums.length; i ++) {
            prefix[i] = prefix[i] + prefix[i - 1]; 
        }    
    }
    
    public int sumRange(int left, int right) {

        int leftValue = left == 0 ? 0 : prefix[left - 1];

        return prefix[right] - leftValue;
    
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */