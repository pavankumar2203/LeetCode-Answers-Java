public class Solution {
    public int atoi(String str) {
        /*
            null check
            trim
            empty check
            save sign
            remove all chars after non digit char(including this non digit char)
            length check
            convert to long
            add sign
            if overflow return max or min
            return val
            
            O(n) O(1)
        */
        
        if(str == null) {
            throw new IllegalArgumentException("Illegal arg");
        }
        
        str = str.trim();
        
        if(str.equals("")) {
            //throw new IllegalArgumentException("Illegal arg");
            return 0;
        }
        
        boolean isNegative = false;
        if(str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1);
        }
        else if(str.charAt(0) == '+') {
            str = str.substring(1);
        }
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                str = str.substring(0, i);
            }
        }
        
        if(str == "") {
            //throw new IllegalArgumentException("Illegal arg");
            return 0;
        }
        
        // now str should be all digits
        
        long big = 0;
        int len = 0;
        for(int i = 0; i < str.length(); i++) {
            big += Integer.parseInt(Character.toString(str.charAt(i)));
            big *= 10;
            len++;
            if(len > 11) {
                break;
            }
        }
        big /= 10;
        if(isNegative) {
            big = -big;
        }
        
        if(big >= 0x7fffffff) {
            return 0x7fffffff;
        }
        else if(big <= 0x80000000) {
            return 0x80000000;
        }
        
        return (int)big;
    }
}
