class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
        
        for(int[] flight: flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            
            graph.putIfAbsent(from, new ArrayList<Pair<Integer,Integer>>());
            graph.get(from).add(new Pair(to, price));
        }
        
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);     
        
        Queue<List<Integer>> heap = new PriorityQueue<>((state1 , state2) -> state1.get(0) - state2.get(0));
        
        List<Integer> firstNode = new ArrayList<>();
        firstNode.add(0);
        firstNode.add(src);
        firstNode.add(0);
        heap.add(firstNode);
        
        while(!heap.isEmpty()) {
            List<Integer> curr = heap.poll();
            int currPrice = curr.get(0);
            int node = curr.get(1);
            int currNumberOfFlights = curr.get(2);

            if(currNumberOfFlights > stops[node] || currNumberOfFlights > k + 1 ) {
                continue;
            }

            stops[node] = currNumberOfFlights;

            if(node == dst){
                return currPrice;
            }

            if(!graph.containsKey(node)){
                continue;
            }
              
            for(Pair<Integer,Integer> neiInfo : graph.get(node)) {
                    List<Integer> nextNode = new ArrayList<>();
                    nextNode.add(currPrice + neiInfo.getValue());
                    nextNode.add(neiInfo.getKey());
                    nextNode.add(currNumberOfFlights + 1);
                    heap.add(nextNode);
                }
            }      
    

        return -1;  
    }
}