/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size()==1) return 1;
        if (intervals.size()==0) return 0;

        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval i: intervals){
            if (pq.isEmpty()){
                pq.offer(i.end);
            }
            else if (pq.peek()<=i.start){
                pq.poll();
                pq.offer(i.end);
            }else{
                pq.offer(i.end);
            }
        }

        return pq.size();
    }
}
