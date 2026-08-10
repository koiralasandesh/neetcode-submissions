class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;

        for (int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }

        if (totalGas<totalCost) return -1;

        int currentGas= 0;
        int startIndex = 0;
        int index=0;

        while(index<gas.length){
            currentGas = currentGas+gas[index]-cost[index];
            if (currentGas<0){
                currentGas=0;
                startIndex=index+1;
            }
            index++;
        }

        return startIndex;
    }
}