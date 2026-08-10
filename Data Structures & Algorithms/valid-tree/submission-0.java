class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n==0 && edges.length==0) return true;

        if(edges.length!=(n-1)){
            return false;
        }

        Map<Integer,List<Integer>> adj = new HashMap<>();

        for (int i=0;i<edges.length;i++){
            List<Integer> node = adj.computeIfAbsent(edges[i][0], k->new ArrayList<Integer>());
            node.add(edges[i][1]);

            node = adj.computeIfAbsent(edges[i][1], k->new ArrayList<Integer>());
            node.add(edges[i][0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(0);
        visited.add(0);

        while(!q.isEmpty()){
            int node = q.poll();

            List<Integer> neighbors = adj.getOrDefault(node,new ArrayList<Integer>());

            for(int neighbor: neighbors){
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }

        return visited.size()==n;

    }
}
