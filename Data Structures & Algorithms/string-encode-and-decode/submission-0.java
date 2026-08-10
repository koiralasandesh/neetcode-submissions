class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for (String s : strs){
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<String>();
        int i=0;
        while (i<str.length()){
            int j=i;
            while (str.charAt(j)!='#'){
                j++;
            }

            int encodedLength = Integer.parseInt(str.substring(i,j));
            result.add(str.substring(j+1,j+ encodedLength+1));

            i = j+encodedLength+1;

        }

        return result;
    }
}
