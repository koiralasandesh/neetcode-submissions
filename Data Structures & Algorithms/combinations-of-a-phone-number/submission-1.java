class Solution {
    final private List<String> dict = List.of("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.equals("")){
            return result;
        }
        backtrack(0,digits,result,new StringBuilder());
        return result;
    }
    private void backtrack(int i, String digits,List<String> result,StringBuilder current){
        if (i>digits.length()){
            return;
        }
        if (i==digits.length()){
            result.add(current.toString());
            return;
        }
        String currDigit = dict.get(Character.getNumericValue(digits.charAt(i)));
        for(char c: currDigit.toCharArray()){
            current.append(c);
            backtrack(i+1,digits,result,current);
            current.deleteCharAt(current.length()-1);
        }
    }
}
