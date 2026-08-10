class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        
        for (int i: nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
            (a,b)-> a.getValue()-b.getValue()
        );

        for (Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            minHeap.add(entry);
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }

        int [] result = new int[k];

        for(int i=0;i<k;i++){
            result[i]= minHeap.poll().getKey();
        }

        return result;

    }
}
