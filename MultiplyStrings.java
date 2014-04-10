//O(n^2) O(n)

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1.length() == 0 || num2.length() == 0) return "";
        String result = "";
        for(int i = 0; i < num1.length(); i++) {
            char c = num1.charAt(i);
            String cr = multiply(c, num2);
            StringBuilder sb = new StringBuilder();
            for(int j = num1.length() - 1 - i; j > 0; j--) {
                sb.append('0');
            }
            cr = cr + sb.toString();
            result = add(result, cr);
        }
        while(result.length() > 1) {
            if(result.charAt(0) == '0') result = result.substring(1);
            else break;
        }
        return result;
    }
    private static String multiply(char c, String s) {
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int sd = Integer.parseInt(Character.toString(s.charAt(i)));
            int cd = Integer.parseInt(Character.toString(c));
            int d = ((sd * cd) + carrier) % 10;
            carrier = ((sd * cd) + carrier) / 10;
            sb.append(d);
        }
        if(carrier != 0) sb.append(carrier);
        sb = sb.reverse();
        
        return sb.toString();
    }
    private static String add(String s1, String s2) {
        String l = s1;
        String s = s2;
        if(s1.length() < s2.length()) {
            l = s2;
            s = s1;
        }
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for(int i = 0; i < s.length(); i++) {
            int sd = Integer.parseInt(Character.toString(s.charAt(s.length() - 1 - i)));
            int ld = Integer.parseInt(Character.toString(l.charAt(l.length() - 1 - i)));
            int d = (sd + ld + carrier) % 10;
            carrier = (sd + ld + carrier) / 10;
            sb.append(d);
        }
        for(int i = s.length(); i < l.length(); i++) {
            int ld = Integer.parseInt(Character.toString(l.charAt(l.length() - 1 - i)));
            int d = (ld + carrier) % 10;
            carrier = (ld + carrier) / 10;
            sb.append(d);
        }
        if(carrier != 0) sb.append(carrier);
        sb = sb.reverse();
        
        return sb.toString();
    }
}
