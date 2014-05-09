import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        /**
         * return size is n!*n
         * there may be duplicate numbers
         */
         ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
         if(num==null || num.length==0) return r;
         if(num.length==1) {
             ArrayList<Integer> al = new ArrayList<Integer>();
             al.add(num[0]);
             r.add(al);
             return r;
         }
         ArrayList<ArrayList<Integer>> r1 = permute(Arrays.copyOfRange(num, 1, num.length));
         for(ArrayList<Integer> al1 : r1) {
             int n = num[0];
             for(int i = 0; i <= al1.size(); i++) {
                 ArrayList<Integer> al2 = (ArrayList<Integer>)al1.clone();
                 al2.add(i, n);
                 if(!r.contains(al2)) {
                     r.add(al2);
                 }
             }
         }
         return r;
    }
}
