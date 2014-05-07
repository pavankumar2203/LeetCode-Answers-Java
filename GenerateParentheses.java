import java.util.*;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> arr = new ArrayList<String>();
        if(n<=0) return arr;
        if(n==1) {
            arr.add("()");
            return arr;
        }
        ArrayList<String> arr1 = generateParenthesis(n-1);
        HashSet<String> set = new HashSet<String>();
        for(String s: arr1) {
            set.add("()"+s);
            for(int i = 1; i < s.length(); i++) {
                set.add(s.substring(0,i)+"()"+s.substring(i));
            }
        }
        for(String s:set) {
            arr.add(s);
        }
        return arr;
    }
}
