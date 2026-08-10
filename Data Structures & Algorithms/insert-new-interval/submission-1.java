// [[1,2],[3,5],[9,10]]
// [6,7]

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) return new int[][]{newInterval};

        List<int[]> result = new ArrayList<>();
        
        for(int i=0;i<intervals.length;i++){
            if (newInterval[0]==-1) {
                result.add(intervals[i]);
            }
            else if (intervals[i][1]<newInterval[0]){
                result.add(intervals[i]);
            }else if(intervals[i][0]>newInterval[1]){
                result.add(new int[]{newInterval[0],newInterval[1]});
                newInterval[0]=-1;
                newInterval[1]=-1;
                result.add(intervals[i]);
            }
            else{
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
        }

        if (newInterval[0]>=0){
            result.add(newInterval);
        }

        return result.toArray(new int[0][0]);

        
    }
}
