//O(n) O(n)
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c - 'a' >= 0 && c - 'z' <= 0 || c - '0' >= 0 && c - '9' <= 0) {
                sb.append(c);
            }
        }
        s = sb.toString();
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
