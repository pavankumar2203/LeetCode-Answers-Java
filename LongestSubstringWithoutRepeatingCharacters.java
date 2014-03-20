import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            algo with O(n) time and O(n) space
            set={}
            i=0
            maxlen=0
            while i++<s.length:
                c=s[i]
                if set doesnt contain c:
                //hashset lookup is O(1)
                    s add c
                else:
                    find c's first occurance index i1
                    update maxlen with set.size
                    remove all chars before i1 from set
                    
            update maxlen with set.size
            return maxlen
        */
        
        HashSet<Character> set = new HashSet<Character>();
        int i = 0;
        int maxLen = 0;
        int startIndex = 0; //start index of the elements in set
        while(i < s.length()) {
            char c = s.charAt(i);
            if(!set.contains(c)) {
                set.add(c);
            }
            else {
                maxLen = Math.max(maxLen, set.size());
                for(int j = startIndex; j < i; j++) {
                    if(s.charAt(j) == c) {
                        startIndex = j + 1;
                        break;
                    }
                    else {
                        set.remove(s.charAt(j));
                    }
                }
            }
            i++;
        }
        
        maxLen = Math.max(maxLen, set.size());
        return maxLen;
    }
}
