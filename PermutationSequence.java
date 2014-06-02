import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        k-=1;
        int[] p = new int[10];
        p[0] = 1;
        p[1] = 1;
        for (int i = 2; i < 10; i++) {
            p[i] = i * p[i - 1];
        }
        int[] r = new int[n];
        int nn = n;
        while (k > 0) {
            r[nn-1] = k / p[nn];
            k %= p[nn--];
        }
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i = 1; i<=n;i++) list.add(i);
        StringBuilder sb = new StringBuilder();
        for(int i = r.length-2; i>=0; i--) {
            int v = list.get(r[i]);
            sb.append(v);
            list.remove(r[i]);
        }
        sb.append(list.get(0));
        return sb.toString();
    }
}
