class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length==0 || intervals.length==1) return intervals;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for (int i =1;i<intervals.length;i++){
            int j=result.size()-1;
            if(result.get(j)[1]>=intervals[i][0]){
                result.get(j)[1]=Math.max(result.get(j)[1],intervals[i][1]);
            }
            else{
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[0][0]);
    }
}
