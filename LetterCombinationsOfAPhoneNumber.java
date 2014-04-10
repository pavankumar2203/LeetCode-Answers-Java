/**
 * T(n) = T(1)+T(n-1)+3*3^(n-1) ==> O(3^n)
 */
 
import java.util.ArrayList;

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits == null) return result;
        if(digits.length() == 0) {
            result.add("");
            return result;
        }
        if(digits.length() == 1) {
            switch(digits.charAt(0)) {
                case '2' : result.add("a"); result.add("b"); result.add("c"); break;
                case '3' : result.add("d"); result.add("e"); result.add("f"); break;
                case '4' : result.add("g"); result.add("h"); result.add("i"); break;
                case '5' : result.add("j"); result.add("k"); result.add("l"); break;
                case '6' : result.add("m"); result.add("n"); result.add("o"); break;
                case '7' : result.add("p"); result.add("q"); result.add("r"); result.add("s"); break;
                case '8' : result.add("t"); result.add("u"); result.add("v"); break;
                case '9' : result.add("w"); result.add("x"); result.add("y"); result.add("z"); break;
                default: break;
            }
        } else {
            ArrayList<String> result1 = letterCombinations(digits.substring(0, 1));
            ArrayList<String> result2 = letterCombinations(digits.substring(1));
            for(String s1 : result1) {
                for(String s2: result2) {
                    result.add(s1 + s2);
                }
            }
        }
        return result;
    }
}
