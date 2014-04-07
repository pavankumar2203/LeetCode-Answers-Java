import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null) return -1;
        if(num.length == 0) return  0;
        int min = num[0];
        int max = min;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++) {
            int n = num[i];
            set.add(n);
            if(n > max) max = n;
            if(n < min) min = n;
        }
        int maxLen = 1;
        for(int i = 0; i < num.length; i++) {
            int n = num[i];
            set.remove(n);
            int len = 1;
            while(n < max) {
                n++;
                if(!set.contains(n)) break;
                len++;
                set.remove(n);
            }
            n = num[i];
            while(n > min) {
                n--;
                if(!set.contains(n)) break;
                len++;
                set.remove(n);
            }
            if(len > maxLen) maxLen = len;
        }
        
        return maxLen;
    }
}//O(n) O(n)
