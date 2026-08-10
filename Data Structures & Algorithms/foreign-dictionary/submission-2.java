class Solution {
    public String foreignDictionary(String[] words) {

        Map<Character,Integer> indegree = new HashMap<>();
        Map<Character,HashSet<Character>> adj = new HashMap<>();
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (String word: words){
            for (char c: word.toCharArray()){
                indegree.put(c,0);
                adj.put(c,new HashSet<Character>());
            }
        }

        for(int i=0;i<words.length-1;i++){
            String curr = words[i];
            String next = words[i+1];

            if (curr.length()>next.length() && curr.startsWith(next)) return "";

            int minLen=Math.min(curr.length(),next.length());

            for (int j=0;j<minLen;j++){
                if(curr.charAt(j)!=next.charAt(j)){
                    HashSet<Character> set = adj.get(curr.charAt(j));
                    if (set.add(next.charAt(j))){
                        indegree.put(next.charAt(j),indegree.getOrDefault(next.charAt(j),0)+1);
                    }
                    break;
                }
            }
             
        }

        int visited =0;

        for (Character c: indegree.keySet()){
            if (indegree.get(c)==0){
                q.offer(c);
            }
        }

        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            visited++;
            for(char d: adj.get(c)){
                int ind = indegree.get(d)-1;
                indegree.put(d,ind);
                if (ind==0){
                    q.offer(d);
                }
            }
        }

        return visited==adj.size()? sb.toString() : "";
    }
}
