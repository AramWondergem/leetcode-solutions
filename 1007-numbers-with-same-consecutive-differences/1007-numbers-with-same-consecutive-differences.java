class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        
        StringBuilder curr = new StringBuilder();
        
        for(int i = 1; i < 10; i++) {
            backtrack(curr.append(i), i, n, k, ans);
            curr.deleteCharAt(curr.length() - 1 );
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray(); 
    }
    
    private void backtrack(StringBuilder curr, int lastValue, int n, int k, List<Integer> ans) {
        if(curr.length() == n) {
            ans.add(Integer.valueOf(curr.toString()));
            return;
        }
        
        int j = -1;

        int limit = 2;

        if(k == 0) {
            limit = 1;
        }
        
        for(int l = 0; l < limit; l++){
            int value = lastValue + (k * j);
            j *= -1;
            if(valid(value)){
                backtrack(curr.append(value), value, n , k , ans);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
    
    private boolean valid(int i) {
        return 0 <= i && i <= 9;
    }
}