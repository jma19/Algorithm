### 5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

**Example**

~~~
Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.


Input: "cbbd"

Output: "bb"

~~~






####Analysis & Solution



~~~

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        String max = "";
        for(int i = 1; i < s.length(); i++){
            //when the result  is odd
            String odd = getPalindrome(s, i, i);
            //when the result is even;
            String even = getPalindrome(s, i-1, i);
            
            if(odd.length() > max.length()){
               max  = odd;
            }
            if(even.length() > max.length()){
                max = even;
            }
        }
        return max;
    }
    private String getPalindrome(String s, int i, int j){
         while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
             i--;
             j++;
         }
         return s.substring(i+1, j);
    }

~~~






