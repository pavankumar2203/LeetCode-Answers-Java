import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] num = new int[]{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14,
                -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1,
                6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1,
                4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15,
                7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4,
                1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2,
                6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6};
        long startTime = System.currentTimeMillis();
        new Solution().threeSum(num);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " threeSum");

        startTime = System.currentTimeMillis();
        new Solution().threeSum2(num);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime + " threeSum2");

        startTime = System.currentTimeMillis();
        new Solution().threeSum3(num);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime + " threeSum3");

        startTime = System.currentTimeMillis();
        new Solution().threeSum4(num);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime + " threeSum4");
    }

    //O(n^3)
    public ArrayList<ArrayList<Integer>> threeSum4(int[] num) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                for (int k = j + 1; k < num.length; k++) {
                    int sum = num[i] + num[j] + num[k];
                    if (sum == 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        set.add(list);
                        //break;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> a : set) {
            r.add(a);
        }
        return r;
    }

    //O(n^2log(n))
    public ArrayList<ArrayList<Integer>> threeSum3(int[] num) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                int v = -(num[i] + num[j]);
                if (Arrays.binarySearch(num, j + 1, num.length, v) >= 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(v);
                    set.add(list);
                }
            }
        }
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> a : set) {
            r.add(a);
        }
        return r;
    }

    //O(n^3) optimized
    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum2 = num[i] + num[j];
                while (sum2 + num[k] > 0 && k > j + 1) {
                    k--;
                }
                if (sum2 + num[k] == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    set.add(list);
                }
                j++;
                k = num.length - 1;
            }
        }
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> a : set) {
            r.add(a);
        }
        return r;
    }

    //theoretically O(n^2)
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

        class IndexPair {
            int i;
            int j;

            IndexPair(int a, int b) {
                i = a;
                j = b;
            }
        }

        HashMap<Integer, ArrayList<IndexPair>> map =
                new HashMap<Integer, ArrayList<IndexPair>>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                ArrayList<IndexPair> al = map.containsKey(num[i] + num[j])
                        ? map.get(num[i] + num[j]) : new ArrayList<IndexPair>();
                al.add(new IndexPair(i, j));
                map.put(num[i] + num[j], al);
            }
        }

        for (int k = 0; k < num.length; k++) {
            if (map.containsKey(-num[k])) {
                for (IndexPair pair : map.get(-num[k])) {
                    if (k > pair.j) {
                        ArrayList<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(num[pair.i]);
                        triplet.add(num[pair.j]);
                        triplet.add(num[k]);
                        set.add(triplet);
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> a : set) {
            r.add(a);
        }

        return r;
    }
}
