class Solution {
    public int[][] kClosest(int[][] points, int k) {
        record Point(int x, int y){}

        int[][] result = new int[k][2];

        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a,b)->
        {
            double aDist = Math.pow(a.x(),2)+Math.pow(a.y(),2);
            double bDist = Math.pow(b.x(),2)+Math.pow(b.y(),2);

            return (int) Double.compare(bDist,aDist);
        });

        for (int[] point: points){
            maxHeap.offer(new Point(point[0],point[1]));
            if (maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        for (int i=0;i<k;i++){
            Point p = maxHeap.poll();
            result[i] = new int[]{p.x(),p.y()};
        }

        return result;

    }
}
