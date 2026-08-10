class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int [] results = new int[queries.length];
        int [][] q = new int[queries.length][2];

        for (int i=0;i<queries.length;i++){
            q[i]=new int[]{queries[i],i};
        }
        Arrays.sort(q,(a,b)->Integer.compare(a[0],b[0]));

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        
        int i=0;

        for (int[] query: q){

            while((i<intervals.length) && (intervals[i][0]<=query[0])){
                pq.offer(new int[]{intervals[i][1]-intervals[i][0]+1,intervals[i][1]});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1]<query[0]){
                pq.poll();
            }

            int [] result = pq.peek();
            if (result==null){
                results[query[1]]=-1;
            }
            else{
                results[query[1]] =result[0];
            }
            
        }

        return results;

    }
}
