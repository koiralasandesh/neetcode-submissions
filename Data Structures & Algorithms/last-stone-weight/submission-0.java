class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer> (Collections.reverseOrder());

        for (int n: stones){
            maxHeap.offer(n);
        }

        while(maxHeap.size()>1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            int c = calculate(a,b);
            if (c>0) maxHeap.offer(c);
        }

        if(maxHeap.size()>0){
            return maxHeap.poll();
        }

        return 0;
        
    }

    private int calculate(int a , int b){
        if(a==b) return 0;
        return a-b;
    }
}
