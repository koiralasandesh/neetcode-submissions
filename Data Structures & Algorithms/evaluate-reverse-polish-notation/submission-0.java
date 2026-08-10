class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s: tokens){
            if (s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if (s.equals("-")){
                int firstNum = stack.pop();
                int secondNum = stack.pop(); 
                stack.push(secondNum-firstNum);

            }else if (s.equals("*")){
                stack.push(stack.pop()*stack.pop());              
            }else if(s.equals("/")){
                int firstNum = stack.pop();
                int secondNum = stack.pop();
                stack.push(secondNum/firstNum);
            }else{
                stack.push(Integer.parseInt(s));
            }

        }

        return stack.pop();
    }
}
