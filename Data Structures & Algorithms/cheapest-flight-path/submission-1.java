class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[src] =0;

        for (int i=0;i<k+1;i++){
            int [] temp = costs.clone();

            for (int j=0;j<flights.length;j++){
                if (!(costs[flights[j][0]]==Integer.MAX_VALUE)){
                    temp[flights[j][1]]=Math.min(temp[flights[j][1]],costs[flights[j][0]]+flights[j][2]);
                }
            }
            costs=temp.clone();
        }

        return (costs[dst] <Integer.MAX_VALUE) ? costs[dst] : -1; 
    }
}
