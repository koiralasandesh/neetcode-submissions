class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int nodes=0;

        int [] indegrees = new int [numCourses];

        for (int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for (int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i=0;i<numCourses;i++){
            if (indegrees[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int course = q.poll();
            nodes++;
            List<Integer> pre= adj.get(course);
            for (int preCourse : pre){
                indegrees[preCourse]--;
                if (indegrees[preCourse]==0){
                    q.offer(preCourse);
                }
            }
        }

        if (nodes==numCourses){
            return true;
        }

        return false;


    }
}
