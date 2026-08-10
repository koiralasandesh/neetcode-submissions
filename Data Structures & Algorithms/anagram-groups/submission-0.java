class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();


        Map<String,List<String>> freqMapPerString = new HashMap<>();


        for (int i=0;i<strs.length;i++){
            String str = strs[i];
            int[] freq = new int[26];
            for (char c: str.toCharArray()){
                freq[c-'a']++;
            }

            //convert freqarray to string
            StringBuilder freqMap = new StringBuilder();

            for (int j: freq){
                freqMap.append(j).append('#');
            }
            String freqMapString = freqMap.toString();

            if (freqMapPerString.containsKey(freqMapString)){
                freqMapPerString.get(freqMapString).add(str);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(str);
                freqMapPerString.put(freqMapString,temp);
            }

            // System.out.println(freqMapPerString);

            // for (List<String> strss: freqMapPerString.values()){
            //     result.add(strss);
            // }



        }
        return new ArrayList<List<String>>(freqMapPerString.values());
    }
}
