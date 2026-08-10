class Solution {
    public boolean isValid(String s) {

        // if (s.length()<=0){
        //     return false;
        // }

       Deque <Character> stack = new ArrayDeque<>();

       for (char c: s.toCharArray()){
        if (c =='[' || c=='{' || c=='('){
            stack.push(c);
        }
        else if (c==']'){
           if( !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
           }else{
            return false;
           }
        }
        else if (c=='}'){
            if (!stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }else{
                return false;
            }
        }
        else if (c==')'){
            if(!stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            } else{
                return false;
            }
        }else{
            return false;
        }
       } 

       if (stack.isEmpty()){
        return true;
       }

       return false;
    }
}
