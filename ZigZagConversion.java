public class Solution {
    public String convert(String s, int nRows) {
        /*
            consider breaking zigzag to parts like:
            P
            A P
            Y
            
            P is level 1
            A P are level 2
            ...
            Y is level nRows
            
            in 1 part there are (nRows-1)*2 chars
            so there are s.len/((nRows-1)*2) + 1 parts at most
            
            O(n) O(n) algo:
            add level 1
            for each level from 2 to nRows-1:
                add first char
                add 2nd char
            add last level
            
        */
        
        if (s == null || s == "" || nRows == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int nc = (nRows - 1) * 2; //number of chars in 1 part
        int np = s.length() / nc + 1; //number of parts
        
        for(int i = 0; i < np; i++) {
            if(i * nc < s.length()) {
                sb.append(s.charAt(i * nc)); //level 1
            }
        }
        for(int l = 2; l < nRows; l++) {
            for(int i = 0; i < np; i++) {
                if(i * nc + l - 1 < s.length()) {
                    sb.append(s.charAt(i * nc + l - 1));//1st char in level L
                }
                if(i * nc + nc - l + 1 < s.length()) {
                    sb.append(s.charAt(i * nc + nc - l + 1)); //2nd char in level L
                }
            }
        }
        for(int i = 0; i < np; i++) {
            if(i * nc + nRows - 1 < s.length()) {
                sb.append(s.charAt(i * nc + nRows - 1)); //level nRows
            }
        }
        
        return sb.toString();
    }
}
