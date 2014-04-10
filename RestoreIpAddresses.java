public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s == null) return result;
        result = partion(s, 4);
        ArrayList<String> newResult = new ArrayList<String>();
        for(String ss : result) {
            if(!ss.endsWith("x")) {
                newResult.add(ss.substring(0, ss.length() - 1));
            }
        }
        return newResult;
    }
    private static ArrayList<String> partion(String s, int k) {
        ArrayList<String> r = new ArrayList<String>();
        if(s.length() == 0 && k == 0) {
            r.add("");
            return r;
        }
        else if(s.length() == 0 || k == 0) {
            r.add("x");
            return r;
        }
        
        for(String ss : partion(s.substring(1), k - 1)) {
            r.add(s.substring(0, 1) + "." + ss);
        }
        if(s.length() >= 2) {
            String head2 = s.substring(0, 2);
            if(head2.charAt(0) != '0') {
                for(String ss : partion(s.substring(2), k - 1)) {
                    r.add(head2 + "." + ss);
                }
            }
        }
        if(s.length() >= 3) {
            String head3 = s.substring(0,3);
            if(head3.charAt(0) != '0') {
                if(Integer.parseInt(head3) < 256) {
                    for(String ss : partion(s.substring(3), k - 1)) {
                        r.add(head3 + "." + ss);
                    }
                }
            }
        }
        return r;
    }
}
