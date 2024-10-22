class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0 ) {
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        
        int[][] arrayWithAddedInterval = new int[intervals.length + 1][2];
        List<int[]> ans = new LinkedList<>();
        
        int isAdded = 0;
        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            if(isAdded == 0 && start >= newInterval[0]) {
                arrayWithAddedInterval[i] = newInterval;
                isAdded = 1;
            }
            
            arrayWithAddedInterval[i + isAdded] = intervals[i];
        }
        
        if(isAdded == 0) {
            arrayWithAddedInterval[arrayWithAddedInterval.length - 1] = newInterval;
        }
        
        for(int[] interval: arrayWithAddedInterval) {
            int currStart = interval[0];
            int currEnd = interval[1];
            
            if(!ans.isEmpty() && currStart <= ans.getLast()[1]) {
                ans.getLast()[1] = Math.max(ans.getLast()[1],currEnd);
            } else {
                ans.add(interval);
            }
                
        }
        
        return ans.toArray(new int[ans.size()][]);
            
            
                
    }
}