public class Solution {
    public int romanToInt(String s) {
        int r = 0;
        s = s.trim();
        s = s.toUpperCase();
        char min = 'M';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'M') {
                r += 1000;
                if(min == 'C') {
                    r -= 200;
                }
                min = 'M';
            }
            else if(c == 'D') {
                r += 500;
                if(min == 'C') {
                    r -= 200;
                }
                min = 'D';
            }
            else if(c == 'C') {
                r += 100;
                if(min == 'X') {
                    r -= 20;
                }
                min = 'C';
            }
            else if(c == 'L') {
                r += 50;
                if(min == 'X') {
                    r -= 20;
                }
                min = 'L';
            }
            else if(c == 'X') {
                r += 10;
                if(min == 'I') {
                    r -= 2;
                }
                min = 'X';
            }
            else if(c == 'V') {
                r += 5;
                if(min == 'I') {
                    r -= 2;
                }
                min = 'V';
            }
            else if(c == 'I') {
                r += 1;
                min = 'I';
            }
            else {
                throw new IllegalArgumentException("illegal arg");
            }
        }
        
        return r;
    }
}
