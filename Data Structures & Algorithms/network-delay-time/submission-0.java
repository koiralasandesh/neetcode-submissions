class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        record DestTime(int dest,int time){};
        // source,[dest, timet0dest]
        Map<Integer,List<DestTime>> adj = new HashMap<>();
        // node, shortesttimetonode
        Map<Integer,Integer> timeToNode = new HashMap<>();
        PriorityQueue<DestTime> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time(),b.time()));

        int maxTime =0;

        for (int i=0;i<times.length;i++){
            adj.computeIfAbsent(times[i][0],p->new ArrayList<DestTime>()).add(new DestTime(times[i][1],times[i][2]));
        }

        pq.offer(new DestTime(k,0));

        while(!pq.isEmpty()){
            DestTime temp = pq.poll();
            if (!timeToNode.containsKey(temp.dest())){
                maxTime=Math.max(maxTime,temp.time());
                timeToNode.put(temp.dest(),temp.time());
                List<DestTime> neighbors = adj.getOrDefault(temp.dest(),new ArrayList());
                for (DestTime neighbor: neighbors){
                    if (!timeToNode.containsKey(neighbor.dest())){
                        pq.offer(new DestTime(neighbor.dest(),temp.time()+neighbor.time()));
                    }
                }
            }
        }

        return (timeToNode.size()==n)? maxTime : -1;

    }
}
