class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (List<String> ticket: tickets){
            adj.computeIfAbsent(ticket.get(0),k->new PriorityQueue<String>()).offer(ticket.get(1));
        }

        dfs(adj,"JFK",result);

        Collections.reverse(result);

        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String source,List<String> result){
        PriorityQueue<String> pq = adj.get(source);

        while(pq!=null && !pq.isEmpty()){
            String dest = pq.poll();
            dfs(adj,dest,result);  
        }
        result.add(source);
    }
}
 