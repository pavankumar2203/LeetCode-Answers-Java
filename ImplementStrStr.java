/**
 * O(n) O(1)
 */

public class Solution {
    public String strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if(needle.equals(haystack.substring(i, needle.length() + i))) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
