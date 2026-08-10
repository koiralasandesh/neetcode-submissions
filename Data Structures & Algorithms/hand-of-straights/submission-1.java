class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) return true;

        if (hand.length % groupSize != 0) return false;

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i: hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        minHeap.addAll(map.keySet());

        while(!minHeap.isEmpty()){
            int first = minHeap.peek();
            for (int i =first;i<first+groupSize;i++){

                if (!map.containsKey(i)) return false;
                int temp=map.get(i);
                map.put(i,--temp);
                if(temp==0){
                    if(minHeap.peek()==i){
                        minHeap.poll();
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
