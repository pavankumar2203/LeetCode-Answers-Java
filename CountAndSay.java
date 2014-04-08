/**
 * O(n^2) O(n)
 */

import java.util.LinkedList;

public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 1;
        list.add(i);
        while(i < n) {
            int size = list.size();
            int prev = -1;
            int count = 0;
            for(int j = 0; j < size; j++) {
                int d = list.poll();
                if(d != prev) {
                    if(prev != -1) {
                        list.add(count);
                        list.add(prev);
                    }
                    prev = d;
                    count = 1;
                }
                else {
                    count++;
                }
            }
            list.add(count);
            list.add(prev);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(int d : list) {
            sb.append(d);
        }
        return sb.toString();
    }
}
