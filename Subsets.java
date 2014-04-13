import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
         Arrays.sort(S);
         ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
         r.add(new ArrayList<Integer>());
         for(int i = 0; i < S.length; i++) {
             int len = r.size();
             for(int j = 0; j < len; j++) {
                 ArrayList<Integer> rr = new ArrayList<Integer>();
                 for(int n : r.get(j)) {
                     rr.add(n);
                 }
                 rr.add(S[i]);
                 r.add(rr);
             }
         }
         return r;
    }
}
// O(n2^n) O(1)
