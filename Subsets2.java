public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        //map<n, times>
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        r.add(new ArrayList<Integer>());
        Arrays.sort(num);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : num) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for(int i = 0; i < num.length; i++) {
            if(i == 0 || num[i] != num[i - 1]) {
                int n = num[i];
                int times = map.get(n);
                int len = r.size();
                for(int m = 0; m < len; m++) {
                    ArrayList<Integer> rr = r.get(m);
                    for(int j = 0; j < times; j++) {
                        ArrayList<Integer> rr1 = new ArrayList<Integer>();
                        for(int x : rr) {
                            rr1.add(x);
                        }
                        for(int k = 0; k <= j; k++) {
                            rr1.add(n);
                        }
                        r.add(rr1);
                    }
                }
            }
        }
        return r;
    }
}
