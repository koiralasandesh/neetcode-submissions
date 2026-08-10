class Solution {
    public List<Integer> partitionLabels(String s) {

        if (s.length()==1) return new ArrayList(List.of(1));
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int size = 0;
        int end = 0;
        int i=0;

        while(i<s.length()){
            end = Math.max(end,map.get(s.charAt(i)));
            size++;

            if (i==end){
                result.add(size);
                size=0;
            }

            i++;
        }

        return result;
    }
}
