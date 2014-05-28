public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch0(s, 0, p, 0);
    }
    private boolean isMatch0(String s, int i, String p, int j) {
        if(j==p.length()) return i==s.length();
        if(i==s.length()) return p.charAt(j)=='*' && isMatch0(s, i, p, j+1);
        if(p.charAt(j)=='?') return isMatch0(s, i+1, p, j+1);
        if(p.charAt(j)!='*') return s.charAt(i)==p.charAt(j) && isMatch0(s, i+1, p, j+1);
        if(p.length()==j+1) return true;
        if(p.charAt(j+1)=='*') return isMatch0(s, i, p, j+1);
        //p is like *[^*]xxxx
        for(int k=i; k<s.length(); k++) {
            if(s.charAt(k)==p.charAt(j+1)) {
                if(isMatch0(s, k+1, p, j+2)) return true;
            }
        }
        return false;
    }
}
