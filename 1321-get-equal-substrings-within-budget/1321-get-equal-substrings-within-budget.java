class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int total = 0;
        int n = s.length();

        while(right < n){
            total += Math.abs(s.charAt(right) - t.charAt(right));
            right++;
            if(total > maxCost) {
                total -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
        }

        return right - left;
        
    }
}