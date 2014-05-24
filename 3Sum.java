import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i=0; i<num.length-2; i++) {
            int j=i+1;
            int k=num.length-1;
            while(j<k) {
                int sum2 = num[i]+num[j];
                while(sum2+num[k]>0 && k>j+1) {
                    k--;
                }
                if(sum2+num[k]==0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    set.add(list);
                }
                j++;
                k=num.length-1;
            }
        }
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> a:set) {
            r.add(a);
        }
        return r;
    }
}
