class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            if (freqMap.containsKey(nums[i])){
                freqMap.put(nums[i],freqMap.get(nums[i])+1);
            }else{
                freqMap.put(nums[i],1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
            (a,b)-> a.getValue()- b.getValue()
        );

        for (Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            minHeap.add(entry);
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }

        int result[] = new int[k];
        for (int i=0;i<k;i++){
            result[i]= minHeap.poll().getKey();
        }

        return result;
    
    
    }
}
