/**
 * strs => HashMap<HashMap<Character, Integer>, ArrayList<String>>
 * O(str1.length() + str2.length() + str3.length() + ...)
 * O(str1.length() + str2.length() + str3.length() + ...)
 */

import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = 
            new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
        ArrayList<String> r = new ArrayList<String>();
        if(strs == null || strs.length == 0) return r;
        for(int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> m = new HashMap<Character, Integer>();
            String ss = strs[i];
            for(int j = 0; j < ss.length(); j++) {
                if(m.containsKey(ss.charAt(j))) {
                    m.put(ss.charAt(j), m.get(ss.charAt(j)) + 1);
                } else {
                    m.put(ss.charAt(j), 1);
                }
            }
            if(map.containsKey(m)) {
                ArrayList<String> al = map.get(m);
                al.add(ss);
                map.put(m, al);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(ss);
                map.put(m, al);
            }
        }
        for(ArrayList<String> v : map.values()) {
            if(v.size() > 1) {
                r.addAll(v);
            }
        }
        return r;
    }
}
