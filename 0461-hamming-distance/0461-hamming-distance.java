class Solution {
    public int hammingDistance(int x, int y) {
        
        int z = x ^ y;
        
        int ans = 0;
        
        while(z != 0) {
            ans++;
            z = z & (z-1);
            
        }
        
        return ans;
         
    }
}