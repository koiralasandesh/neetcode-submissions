class Solution {
    public int leastInterval(char[] tasks, int n) {

        record CoolDownTask (int task, int timeAvl){}

        Queue<CoolDownTask> taskQ = new ArrayDeque<>();

        PriorityQueue<Integer> readyTasks = new PriorityQueue<>(Collections.reverseOrder());

        int time =0;

        int [] freqMap = new int[26];

        for (char c: tasks){
            freqMap[c-'A']++;
        }

        for (int i=0;i<26;i++){
            if (freqMap[i]>0) readyTasks.offer(freqMap[i]);
        }

        while(!taskQ.isEmpty() || !readyTasks.isEmpty()){
            while (!taskQ.isEmpty() && taskQ.peek().timeAvl()<=time){
                readyTasks.offer(taskQ.poll().task());
            }

            if (!readyTasks.isEmpty()){
                int currentTask = readyTasks.poll();
                if (--currentTask>0) taskQ.offer(new CoolDownTask(currentTask,time+n+1) );
            }

            time++;

        }

        return time;


    }
}
