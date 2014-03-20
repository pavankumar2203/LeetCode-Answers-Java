public class Solution {
    public String longestPalindrome(String s) {
        /*
            consider the center of a palindrome - there are two cases:
                1. **BAB**
                2. **ABBA**
            so we can scan s twice for each case
            for each possible center, expand 1 char to both sides till find unmatched chars. 
            
            worse case O(n^2) time O(1) space
        */
        
        if(s == null || s == "") {
            return s;
        }
        
        int maxLen = 1;
        int startIndex = 0;
        int endIndex = 1; //not inclusive
        
        //case **BAB**
        for(int i = 0; i < s.length(); i++) {
            int j = 1; //j is distance from i
            int len = 1;
            while(i - j >= 0 && i + j < s.length()) {
                if(s.charAt(i - j) == s.charAt(i + j)) {
                    len += 2;
                    j++;
                }
                else {
                    break;
                }
            }
            if(len > maxLen) {
                maxLen = len;
                startIndex = i - j + 1;
                endIndex = i + j;
            }
        }
        
        //case **ABBA**
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                int j = 1;
                int len = 2;
                while(i - j >= 0 && i + 1 + j < s.length()) {
                    if(s.charAt(i - j) == s.charAt(i + 1 + j)) {
                        len += 2;
                        j++;
                    }
                    else {
                        break;
                    }
                }
                if(len > maxLen) {
                    maxLen = len;
                    startIndex = i - j + 1;
                    endIndex = i + 1 + j;
                }
            }
        }
        
        return s.substring(startIndex, endIndex);
    }
}
