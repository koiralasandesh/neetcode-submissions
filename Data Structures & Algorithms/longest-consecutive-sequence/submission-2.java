class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length==0){
            return 0;
        }

        var pq = new PriorityQueue<Integer>();
        for (int num: nums){
            pq.offer(num);
        }

        int result=1;
        int prev=pq.poll();
        int runningTotal=1;
        while(!pq.isEmpty()){
            int next = pq.poll();
            if (next==prev+1){
                runningTotal++;
                result=Math.max(runningTotal,result);
            }
            else if(next!=prev){
                runningTotal=1;
            }
            prev=next;
        }

        return result;
    }
}
