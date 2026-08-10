class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean i=false;
        boolean j=false;
        boolean k=false;

        for (int[] triplet : triplets){
            i |=(triplet[0]==target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]);
            j |=(triplet[1]==target[1] && triplet[2]<=target[2] && triplet[0]<=target[0]);
            k |=(triplet[2]==target[2] && triplet[0]<=target[0] && triplet[1]<=target[1]);
        }

        return (i && j && k);
    }
}
