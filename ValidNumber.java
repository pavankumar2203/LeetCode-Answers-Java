public class Solution {
    public boolean isNumber(String s) {
        /**
         * null check
         * trim
         * to uppercase
         * only +-.E0123456789
         * split s with seperate E => s1 and s2
         * s1: a double or int with optional + or - in the beginning
         * s2: an int with optional + or - in the beginning
         * 
         * O(n) O(n)
         */
         
         if(s == null) return false;
         s = s.trim();
         s = s.toUpperCase();
         int digitCount = 0;
         for(int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (!(c == '+' || c == '-' || c == '.' || c == 'E' || (c - '0' >=0 && c - '0' <= 9))) {
                 return false;
             }
             if((c - '0' >=0 && c - '0' <= 9)) {
                 digitCount++;
             }
         }
         if(digitCount == 0) return false;
         if(s.indexOf('E') != -1) {
             String s1 = s.substring(0, s.indexOf('E'));
             String s2 = s.substring(s.indexOf('E') + 1);
             if(s1.length() != 0 && (s1.charAt(0) == '-' || s1.charAt(0) == '+')) {
                 s1 = s1.substring(1);
             }
             if(s2.length() != 0 && (s2.charAt(0) == '-' || s2.charAt(0) == '+')) {
                 s2 = s2.substring(1);
             }
             if(s1.length() == 0) return false;
             if(s2.length() == 0) return false;
             int dotCount = 0;
             digitCount = 0;
             for(int i = 0; i < s1.length(); i++) {
                 char c = s1.charAt(i);
                 if(!((c - '0' >= 0 && c - '0' <= 9) || c == '.')) {
                     return false;
                 }
                 if(c == '.') {
                     dotCount++;
                     if(dotCount > 1) {
                         return false;
                     }
                 }
                 else {
                     digitCount++;
                 }
             }
             if(digitCount == 0) return false;
             for(int i = 0; i < s2.length(); i++) {
                 char c = s2.charAt(i);
                 if(!(c - '0' >= 0 && c - '0' <= 9)) {
                     return false;
                 }
             }
         }
         else {
             String s1 = s;
             if(s1.length() != 0 && (s1.charAt(0) == '-' || s1.charAt(0) == '+')) {
                 s1 = s1.substring(1);
             }
             int dotCount = 0;
             for(int i = 0; i < s1.length(); i++) {
                 char c = s1.charAt(i);
                 if(!((c - '0' >= 0 && c - '0' <= 9) || c == '.')) {
                     return false;
                 }
                 if(c == '.') {
                     dotCount++;
                     if(dotCount > 1) {
                         return false;
                     }
                 }
             }
         }
         return true;
    }
}
