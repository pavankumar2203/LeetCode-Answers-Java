import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int a = 0; a < num.length - 3; a++) {
            for(int b = a+1; b < num.length - 2; b++) {
                for(int c = b+1; c < num.length - 1; c++) {
                    int v = target - num[a] - num[b] - num[c];
                    if(Arrays.binarySearch(num, c+1, num.length, v) >= 0) {
                        ArrayList<Integer> arr = new ArrayList<Integer>();
                        arr.add(num[a]);
                        arr.add(num[b]);
                        arr.add(num[c]);
                        arr.add(v);
                        set.add(arr);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> a:set) r.add(a);
        return r;
    }
}
