class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1) return 0;

        int count=0;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int lastEnd=intervals[0][1];

        for (int i=1;i<intervals.length;i++){
            if(lastEnd>intervals[i][0]){
                count++;
                lastEnd=Math.min(lastEnd,intervals[i][1]);
            }else{
                lastEnd=intervals[i][1];
            }
        }

        return count;
    }
}
