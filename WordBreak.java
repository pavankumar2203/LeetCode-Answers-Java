public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int maxlen = 0;
        for(String ss:dict) {
            maxlen=Math.max(maxlen, ss.length());
        }
        Boolean[] dpr = new Boolean[s.length()];
        if(s.length()==0) return true;
        if(s.length()>=1) {
            dpr[0] = dict.contains(s.substring(0,1));
        }
        for(int i = 1; i<s.length(); i++) {
            boolean found = false;
            for(int j=0;j<maxlen&&i-j-1>=0;j++) {
                if(dict.contains(s.substring(i-j,i+1))&&dpr[i-j-1])
                    found = true;
            }
            dpr[i]=found;
            if(dict.contains(s.substring(0,i+1))) dpr[i]=true;
        }
        return dpr[s.length()-1];
    }
}
