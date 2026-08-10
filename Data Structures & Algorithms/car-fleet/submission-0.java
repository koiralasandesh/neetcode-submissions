class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][]pair = new int[position.length][2];

        for (int i=0;i<position.length;i++){
            pair[i][0]= position[i];
            pair[i][1]=speed[i];
        }

        Arrays.sort(pair, (a,b)->Integer.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i=0;i<position.length;i++){
            Double arrivalTime = (double)(target-pair[i][0])/pair[i][1];
            stack.push(arrivalTime);

            if (stack.size()>=2){
                if (stack.peek()<=stack.get(stack.size()-2)){
                    stack.pop();
                }
            }
        }

        return stack.size();
    }
}
