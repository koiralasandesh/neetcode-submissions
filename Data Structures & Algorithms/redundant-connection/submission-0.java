class Solution {
    static class DSU{
       int [] parent;
       int [] size;

       public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for (int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
       }

       int find(int i){
        if (parent[i]==i){
            return i;
        }
        parent[i]=find(parent[i]);
        return parent[i];
       }

       boolean union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if (pA==pB){
            return false;
        }
        if (size[pA]>size[pB]){
            parent[pB]=pA;
            size[a]+=size[b];
        }
        else{
            parent[pA]=pB;
            size[b]+=size[a];
        }
        return true;
       }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for (int i=0;i<edges.length;i++){
            if (!dsu.union(edges[i][0], edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
        }

        return null;
        
    }
}
