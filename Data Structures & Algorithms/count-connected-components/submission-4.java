class Solution {

    public class DSU{
        int[] parent;
        int[] size;

        public DSU(int n){
            parent = new int[n];
            size = new int[n];

            for (int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public int find(int i){
            if (parent[i]==i){
                return i;
            }
            parent[i]=find(parent[i]);
            return parent[i];
        }

        public boolean union(int a, int b) {
            int parA=find(a);
            int parB=find(b);

            if (parA==parB){
                return false;
            }
            if (size[parA]>=size[parB]){
                size[parA]=size[parA]+size[parB];
                parent[parB]=parA;
            }else{
                size[parB]=size[parA]+size[parB];
                parent[parA]=parB;
            }
            return true;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int count =n;
        DSU dsu = new DSU(n);
        for (int i=0;i<edges.length;i++){
            if (dsu.union(edges[i][0],edges[i][1])){
                count--;
            }
        }
        return count;
    }
}
