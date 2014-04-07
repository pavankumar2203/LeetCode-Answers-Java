import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> r = new ArrayList<String>();
        if(words == null) return r;
        
        for(int i = 0; i < words.length; ) {
            ArrayList<String> l = new ArrayList<String>();
            int len = -1;
            while(len < L) {
                len++;
                if(i < words.length) {
                    l.add(words[i]);
                    len += words[i].length();
                    i++;
                }
                else {
                    break;
                }
            }
            if(len > L && l.size() != 1) {
            	i--;
                l.remove(l.size() - 1);
            }
            r.add(justify(l, L));
        }
        r.set(r.size() - 1, toLeft(r.get(r.size() - 1), L));
        return r;
    }
    private static String justify(ArrayList<String> strs, int L) {
        if(strs.size() == 1) {
            StringBuilder r = new StringBuilder();
            r.append(strs.get(0));
            int r_len = r.length();
            for(int i = 0; i < L - r_len; i++) {
                r.append(" ");
            }
            return r.toString();
        }
        int lc = 0; //letter count
        for(String s : strs) lc += s.length();
        int minSpaces = (L - lc) / (strs.size() - 1);
        StringBuilder r = new StringBuilder();
        r.append(strs.get(0));
        for(int i = 0; i < (L - lc) % (strs.size() - 1); i++) {
            for(int j = 0; j < minSpaces + 1; j++) {
                r.append(" ");
            }
            r.append(strs.get(i + 1));
        }
        for(int i = (L - lc) % (strs.size() - 1) + 1; i < strs.size(); i++) {
            for(int j = 0; j < minSpaces; j++) {
                r.append(" ");
            }
            r.append(strs.get(i));
        }
        return r.toString();
    }
    private static String toLeft(String s, int L) {
        StringBuilder r = new StringBuilder();
        s = s.trim();
        boolean prevIsSpace = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                r.append(c);
                prevIsSpace = false;
            }
            else {
                if(!prevIsSpace) {
                    r.append(c);
                    prevIsSpace = true;
                }
                else {
                    ;
                }
            }
        }
        int len = r.length();
        for(int i = 0; i < L - len; i++) {
            r.append(" ");
        }
        return r.toString();
    }
}
