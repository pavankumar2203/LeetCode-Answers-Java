/**
 * O(n) O(1)
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        s = s.trim();
        int r = 0;
        int len = s.length();
        while(--len >= 0) {
            if(s.charAt(len) != ' ') {
                r++;
            }
            else {
                break;
            }
        }
        
        return r;
    }
}
