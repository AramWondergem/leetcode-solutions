class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        backtrack(queue, ans, graph);
        return ans;  
    }
    
    private void backtrack(List<Integer> curr, List<List<Integer>> ans, int[][] graph) {
        if(curr.getLast() == graph.length - 1) {
            ans.add(new ArrayList<>(curr));
        }
        
        for(int node: graph[curr.getLast()]) {
            curr.add(node);
            backtrack(curr, ans, graph);
            curr.removeLast();
        }
    }
}