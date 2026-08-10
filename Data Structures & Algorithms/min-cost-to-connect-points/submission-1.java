class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited = new boolean[points.length];
        int cost = 0;
        //cost, index to point
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if (!visited[curr[1]]){
                visited[curr[1]]=true;
                cost+=curr[0];
                for(int i=0;i<points.length;i++){
                    if (!visited[i]){
                        int dist = distance(points[curr[1]],points[i]);
                        pq.offer(new int[]{dist,i});
                    }
                }
            }
        }

        return cost;


    }

    private int distance(int[] x, int[] y){
        return Math.abs(x[0]-y[0])+ Math.abs(x[1]-y[1]);
    }
}
