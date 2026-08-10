class Solution {
    final private List<String> dict = List.of("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack(0,digits,result,"");
        return result;
    }
    private void backtrack(int i, String digits,List<String> result,String current){
        if (i>digits.length()){
            return;
        }
        if (i==digits.length()){
            if (!current.equals("")){
                result.add(current);
            }
            return;
        }
        String currDigit = dict.get(Character.getNumericValue(digits.charAt(i)));
        for(char c: currDigit.toCharArray()){
            current+=c;
            backtrack(i+1,digits,result,current);
            current= current.substring(0,current.length()-1);
        }
    }
}
