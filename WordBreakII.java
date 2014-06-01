import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        int maxlen = 0;
        for(String ss:dict) {
            maxlen = Math.max(maxlen, ss.length());
        }
        
        for(int i = 0; i < s.length(); i++) {
            ArrayList<String> list = new ArrayList<String>();
            for(int j = 0; j<maxlen; j++) {
                if(i>j) {
                    String ss = s.substring(i-j, i+1);
                    ArrayList<String> list1 = map.get(i-j-1);
                    if(dict.contains(ss) && !list1.isEmpty()) {
                        for(String sss:list1) {
                            StringBuilder sb = new StringBuilder(sss);
                            sb.append(' ');
                            sb.append(ss);
                            list.add(sb.toString());
                        }
                    }
                }
                if(i==j) {
                    String ss = s.substring(i-j, i+1);
                    if(dict.contains(ss)) {
                        list.add(ss);
                    }
                }
            }
            map.put(i, list);
        }
        return map.get(s.length()-1);
    }
}

/* DP
map := (k, wordBreak(s.substring(0,k+1), dict))
maxlen := max length of words in dict

for i in [0, len(s)):
    list := empty string list
    for j in [0, maxlen):
        ss = s[i-j, i+1) 
        if i>j:
            if(dict.contains(ss) && map.get(i-j-1) is not empty:
                for sss: map.get(i-j-1):
                    list.add(sss+ " " + ss)
        if i==j:
            if(dict.contains(ss)):
                list.add(ss)
    map.put(i, list)
    
return map.get(s.length()-1)
*/
