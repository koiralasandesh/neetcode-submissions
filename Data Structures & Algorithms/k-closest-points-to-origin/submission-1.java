class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] result = new int[k][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->
        {
            int aDist = a[0]*a[0]+a[1]*a[1];
            int bDist = b[0]*b[0]+b[1]*b[1];

            return Integer.compare(bDist,aDist);
        });

        for (int[] point: points){
            maxHeap.offer(point);
            if (maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        for (int i=0;i<k;i++){
            result[i] = maxHeap.poll();
        }

        return result;

    }
}
