class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int [] indegree = new int[numCourses];
        Queue <Integer> q = new ArrayDeque<>();

        int result[] = new int [numCourses];

        for (int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for (int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;

            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i=0;i<numCourses;i++){
            if (indegree[i]==0){
                q.offer(i);
            }
        }

        int count=0;
        while(!q.isEmpty()){
            int course = q.poll();
            result[count++]=course;

            for (int prereq: adj.get(course)){
                indegree[prereq]--;
                if (indegree[prereq]==0){
                    q.offer(prereq);
                }
            }
        }

        if (count ==numCourses){
            return result;
        }

        return new int[0];

    }
}
