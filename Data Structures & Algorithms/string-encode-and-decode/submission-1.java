class Solution {

    StringBuilder sb = new StringBuilder();


    public String encode(List<String> strs) {
        if (strs.isEmpty()){
            return "";
        }
        sb.setLength(0);
        for (String s: strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.equals("")){
            return new ArrayList<String>();
        }

        char [] chars = str.toCharArray();

        var result = new ArrayList<String>();

        var ind =0;
        while (ind<chars.length){
            var strLenInd =ind;
            while(chars[strLenInd]!='#'){
                strLenInd++;
            }
            int lenStr = Integer.parseInt(new String(chars,ind,strLenInd-ind));
            strLenInd++;

            String s= new String(chars,strLenInd,lenStr);
            result.add(s);
            ind = strLenInd+lenStr;
        }

        return result;

    }
}


// list = hello,how,are,you?,, , how%
// 7 items
// count= 5,3,3,4,0,1,5

// 5#hello3#how10#hellohowar0#3####


// ind=13
// startLenInd=15


