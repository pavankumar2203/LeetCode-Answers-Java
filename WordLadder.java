import java.util.*;

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(start);
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        int length = 0;
        while(!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for(int index = 0; index < size; index++) {
                String s = queue.poll();
                if(s.equals(end)) return length;
                char[] sc = s.toCharArray();
                for (int i = 0; i < sc.length; i++) {
                    char saved = sc[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        sc[i] = c;
                        String s1 = new String(sc);
                        if (dict.contains(s1) && !visited.contains(s1)) {
                            queue.add(s1);
                            visited.add(s1);
                        }
                    }
                    sc[i] = saved;
                }
            }
        }
        return 0;
    }
}
