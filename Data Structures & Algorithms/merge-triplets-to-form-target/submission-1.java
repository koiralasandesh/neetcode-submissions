class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int i=0;
        int j=0;
        int k=0;

        for (int[] triplet : triplets){
            if (triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                i=Math.max(i,triplet[0]);
                j=Math.max(j,triplet[1]);
                k=Math.max(k,triplet[2]);

                if (i==target[0] && j==target[1] && k==target[2]){
                    return true;
                }

            }
        }
        
        return false;
    }
}
