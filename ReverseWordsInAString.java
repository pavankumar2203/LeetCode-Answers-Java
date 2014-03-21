public class Solution {
    public String reverseWords(String s) {
        /*
            lastWordEndIndex li=s.len
            for i from s.len-1 to 0:
                if s[i]==' ':
                    retval+=s[i+1..li]
                    retval+=' '
                    li=i
            O(n) O(1)
        */
        s = s.trim();
        
        int li = s.length();
        StringBuilder retval = new StringBuilder();
        boolean prevIsSpace = false;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                retval.append(s.substring(i + 1, li));
                if(!prevIsSpace) {
                    retval.append(" ");
                }
                li = i;
                prevIsSpace = true;
            }
            else {
                prevIsSpace = false;
            }
        }
        retval.append(s.substring(0, li));
        
        return retval.toString();
    }
}
