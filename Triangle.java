public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        /*
            dp
            save only 1 line
            
            O(n^2) O(n)
        */
        
        int[] s = new int[triangle.size()];
        int[] t = new int[triangle.size()];
        
        for(ArrayList<Integer> list : triangle) {
            if(list.size() == 1) t[0] = s[0] = list.get(0);
            else {
                for(int i = 0; i < list.size(); i++) {
                    if(i == 0) t[0] = s[0] + list.get(0);
                    else if(i == list.size() - 1) {
                        t[i] = s[i - 1] + list.get(i);
                    }
                    else {
                        t[i] = list.get(i) + Math.min(s[i], s[i - 1]);
                    }
                }
            }
            for(int j = 0; j < t.length; j++) s[j] = t[j];
        }
        
        int min = s[0];
        for(int i : s) {
            if(i < min) min = i;           
        }
        
        return min;
    }
}
