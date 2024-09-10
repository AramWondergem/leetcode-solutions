class Solution {
    List<String> ans;
    int n;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<>();
        
        backtrack(new StringBuilder(), 0, 0);
        
        
        return ans;
    }
    
    private void backtrack(StringBuilder curr, int open, int closed) {
        if(n == closed) {
            ans.add(curr.toString());
            return;
        }
        
        List<Character> options = new ArrayList<>(2);
        
        if(open < n) {
           options.add('('); 
        }
        
        if(open > closed){
            options.add(')');
        }
        
        for(char c: options){
            curr.append(c);
            if(c == '(') {
                backtrack(curr, open + 1, closed); 
            } else {
                backtrack(curr, open, closed + 1);
            }
            curr.deleteCharAt(curr.length() - 1);
        }
        
        return;
    }
}