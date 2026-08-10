class Solution {
    public String minWindow(String s, String t) {
        // create freqmap for t
        // track required min # of chars = required
        // track through the sliding window, the # of characters found from required = found
        // loop through chars in s:
        //      if this char is in t, update  found
        //      check to see if we found all required chars
        //          if yes, shrink the window
        //               when shrinking the window, we decrement found
        //          not, keep looping

        int found=0, required =0;
        int startIdx =0;
        int length =Integer.MAX_VALUE;

        HashMap <Character, Integer> targetMap = new HashMap<>();
        HashMap <Character, Integer> windowMap = new HashMap<>();

        for (char c: t.toCharArray()){
            targetMap.merge(c,1,Integer::sum);
        }
        required = targetMap.size();

        int left=0;

        for (int right =0; right<s.length(); right++){

            char c = s.charAt(right);

            windowMap.put(c,windowMap.getOrDefault(c,0)+1);
            if (targetMap.containsKey(s.charAt(right)) && windowMap.get(c).equals(targetMap.get(c))){
                found++;
            }
            while (found==required){
                if (length>right-left+1){
                    length=right-left+1;
                    startIdx=left;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar,windowMap.get(leftChar)-1);
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar)<targetMap.get(leftChar)){
                    found--;
                }
                left++;
            }

        }

        if (length==Integer.MAX_VALUE){
                return "";
        }

        return s.substring(startIdx,startIdx+length);
    }
}
