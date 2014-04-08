public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Label:
        while(i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != c) {
                    break Label;
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }
}
