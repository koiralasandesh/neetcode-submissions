// [[1,2],[3,5],[9,10]]
// [6,7]

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) return new int[][]{newInterval};

        List<int[]> result = new ArrayList<>();
        int i=0;

        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i<intervals.length && intervals[i][1]>=newInterval[0] && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][0]);
        
    }
}
