public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return numDecodings0(s, map);
    }
    public int numDecodings0(String s, HashMap<String, Integer> map) {
        if(map.containsKey(s)) return map.get(s);
        
        if(s.length()==0) return 1;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)) return 0;
            if(c=='0') {
                if(!(i!=0 && (s.charAt(i-1)=='2' || s.charAt(i-1)=='1'))) return 0;
                
                int r = numDecodings0(s.substring(0, i-1), map) * numDecodings0(s.substring(i+1), map);
                map.put(s, r);
                return r;
            }
        }
        
        if(s.length() == 1) return 1;
        
        if(s.length() == 2) {
            int v = Integer.valueOf(s);
            if(v < 27) return 2;
            else return 1;
        }
        
        int v = Integer.valueOf(s.substring(0, 2));
        if(v >= 27) {
            int r = numDecodings0(s.substring(1), map);
            map.put(s, r);
            return r;
        }
        else {
            int r = numDecodings0(s.substring(1), map) + numDecodings0(s.substring(2), map);
            map.put(s, r);
            return r;
        }
    }
}
