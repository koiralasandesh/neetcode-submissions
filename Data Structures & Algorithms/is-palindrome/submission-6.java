class Solution {
    public boolean isPalindrome(String s) {
       int left =0;
       int right= s.length()-1;

       while(left<right){
        while (!Character.isLetterOrDigit(s.charAt(left)) && (left<right)){
            left++;
        }
        while (!Character.isLetterOrDigit(s.charAt(right)) && (left<right)){
            right--;
        }
        if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
            return false;
        }
        left++;
        right--;
       }
       return true; 
    }
}


// Was it a car or a cat I saw?

// left =0
// right=28-1 =27

// left =0,r=26
// left=1,right=25


