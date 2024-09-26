class Solution {
    List<List<Integer>> ans;
    int count;
    int total;

    
    public List<List<Integer>> combinationSum3(int k, int n){
        this.ans = new ArrayList<>();
        this.count = k;
        this.total = n;

        
        if((count/2)*(1 + count) > total){
            return this.ans;
        }
        
        LinkedList<Integer> curr = new LinkedList<>();
        
        for(int i = 1; i < 10; i++){
            curr.add(i);
            backtrack(curr, i, i + 1);
            curr.removeLast();
        }
        return this.ans;
    }
    
    private void backtrack(LinkedList<Integer> curr, int currTotal, int j){
        if(total == currTotal && curr.size() == count){
            this.ans.add(new ArrayList<Integer>(curr));
            return;
        }
        
        if(currTotal >= total){
            return;
        }
        
        for(int i = j; i < 10; i++){
                curr.add(i);
                backtrack(curr, currTotal + i, i + 1);
                curr.removeLast();  
        }
    }
}