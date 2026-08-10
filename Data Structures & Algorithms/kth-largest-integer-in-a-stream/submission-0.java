class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        this.k =k;
        for (int n: nums){
            minHeap.offer(n);
            removeExtra();
        }
        
    }
    
    public int add(int val) {
        minHeap.offer(val);
        removeExtra();
        return minHeap.peek();
    }

    private void removeExtra(){
        if(minHeap.size()>k){
            minHeap.poll();
        }
    }
}
