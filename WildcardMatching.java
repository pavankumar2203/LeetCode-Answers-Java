public class Solution {
    public boolean isMatch(String s, String p) {
        p = removeDuplicateStars(p); //O(P)
        return isMatch0(s, p);
    }
    private boolean isMatch0(String s, String p) {
        if(s.equals(p)) return true;
        if (s.isEmpty() || p.isEmpty()) return p.equals("*");
        char pc = p.charAt(0);
        char sc = s.charAt(0);
        if (pc != '*' && pc != '?') {
            return pc == sc && isMatch0(s.substring(1), p.substring(1)); // T(S-1, P-1)
        }
        if (pc == '?') {
            return isMatch0(s.substring(1), p.substring(1)); // T(S-1, P-1)
        }
        if(p.charAt(p.length()-1)!='*'){
            return isMatch0(new StringBuilder(s).reverse().toString(),
                    new StringBuilder(p).reverse().toString());
        }
        for(int i = s.length(); i >= 0; i--) {
            if(isMatch0(s.substring(i), p.substring(1))) return true; //S*T(S-1, P-1)
        }
        return false;
    }

    private String removeDuplicateStars(String s) {
        if (s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char c0 = s.charAt(i - 1);
            if (!(c == '*' && c0 == '*')) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
