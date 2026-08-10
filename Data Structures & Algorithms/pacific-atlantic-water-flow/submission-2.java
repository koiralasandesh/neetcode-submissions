class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        
        int rows = heights.length;
        int cols = heights[0].length;

        int [][] pacFlow = new int[rows][cols];
        int [][] atlFlow = new int[rows][cols];

        Queue <int[]> pacBFS= new LinkedList<>();
        Queue <int[]> atlBFS = new LinkedList<>();

        for (int i=0;i<cols;i++){
            pacFlow[0][i]=1;
            pacBFS.offer(new int[]{0,i});
        }
        for (int j=1;j<rows;j++){
            pacFlow[j][0]=1;
            pacBFS.offer(new int[]{j,0});
        }

        while(!pacBFS.isEmpty()){
            int[] cell = pacBFS.poll();
            int i = cell[0];
            int j = cell[1];
            if (isCellValid(i+1,j,heights,pacFlow)){
                if (doesWaterFlow(i+1,j,heights[i][j],heights)){
                    pacFlow[i+1][j]=1;
                    pacBFS.offer(new int []{i+1,j});
                }

            }
            if (isCellValid(i-1,j,heights,pacFlow)){
                if (doesWaterFlow(i-1,j,heights[i][j],heights)){
                    pacFlow[i-1][j]=1;
                    pacBFS.offer(new int []{i-1,j});
                }

            }
            if (isCellValid(i,j+1,heights,pacFlow)){
                if (doesWaterFlow(i,j+1,heights[i][j],heights)){
                    pacFlow[i][j+1]=1;
                    pacBFS.offer(new int []{i,j+1});
                }

            }
            if (isCellValid(i,j-1,heights,pacFlow)){
                if (doesWaterFlow(i,j-1,heights[i][j],heights)){
                    pacFlow[i][j-1]=1;
                    pacBFS.offer(new int []{i,j-1});
                }

            }

        }

        for (int i=0;i<cols;i++){
            atlFlow[rows-1][i]=1;
            atlBFS.offer(new int[]{rows-1,i});
        }
        for (int j=0;j<rows-1;j++){
            atlFlow[j][cols-1]=1;
            atlBFS.offer(new int[]{j,cols-1});
        }

        while(!atlBFS.isEmpty()){
            int[] cell = atlBFS.poll();
            int i = cell[0];
            int j = cell[1];
            if (isCellValid(i+1,j,heights,atlFlow)){
                if (doesWaterFlow(i+1,j,heights[i][j],heights)){
                    atlFlow[i+1][j]=1;
                    atlBFS.offer(new int []{i+1,j});
                }

            }
            if (isCellValid(i-1,j,heights,atlFlow)){
                if (doesWaterFlow(i-1,j,heights[i][j],heights)){
                    atlFlow[i-1][j]=1;
                    atlBFS.offer(new int []{i-1,j});
                }

            }
            if (isCellValid(i,j+1,heights,atlFlow)){
                if (doesWaterFlow(i,j+1,heights[i][j],heights)){
                    atlFlow[i][j+1]=1;
                    atlBFS.offer(new int []{i,j+1});
                }

            }
            if (isCellValid(i,j-1,heights,atlFlow)){
                if (doesWaterFlow(i,j-1,heights[i][j],heights)){
                    atlFlow[i][j-1]=1;
                    atlBFS.offer(new int []{i,j-1});
                }

            }

        }

        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (pacFlow[i][j]==1 && atlFlow[i][j]==1){
                    result.add(List.of(i,j));
                }
            }
        }

        return result;
    }

    private boolean isCellValid(int i,int j,int[][] heights,int[][] flows){
        if (i<0 || j<0 || i>=heights.length || j>=heights[0].length || flows[i][j]==1){
            return false;
        }

        return true;
    }
    
    private boolean doesWaterFlow(int i,int j, int currHeight,int[][] heights){
        return currHeight<=heights[i][j];
    }

}
