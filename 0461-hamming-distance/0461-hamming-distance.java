class Solution {
    public int hammingDistance(int x, int y) {
        
        int z = x ^ y;
        
        int ans = 0;
        
        for(int i = 0; i < 31; i++) {
            
            int mask = 1 << i; 
            
            if((z & mask) != 0) {
                ans++;
            }
            
        }
        
        return ans;
         
    }
}