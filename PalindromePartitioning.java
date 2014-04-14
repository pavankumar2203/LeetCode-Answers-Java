public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        /**
         * DP
         * f(s[0..n-1])=sum of [e.add(s[k..n-1]) for e in f(s[0..k-1]) if s[k..n-1] is palindrome] for all k
         * 
         * T(n) = n*n*n?
         */
         ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();
         r.add(new ArrayList<String>());
         if(s == null || s.length() == 0) {
             return r;
         }
         HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
         for(int i = 0; i < s.length(); i++) {
             for(ArrayList<String> arr : r) {
                 arr.add(s.substring(i, i + 1)); //at most 2^n
             }
             for(int j = i - 1; j >= 0; j--) {
                 if(isPalindrome(s.substring(j, i + 1))) {
                     if(j == 0) {
                         ArrayList<String> t = new ArrayList<String>();
                         t.add(s.substring(j, i + 1));
                         r.add(t);
                     } else {
                         for(ArrayList<String> arr : map.get(s.substring(0, j))) {
                             ArrayList<String> t = new ArrayList<String>();
                             t.addAll(arr);
                             t.add(s.substring(j, i + 1));
                             r.add(t);
                         }
                     }
                 }
             }
             ArrayList<ArrayList<String>> r1 = new ArrayList<ArrayList<String>>();
             for(ArrayList<String> ar : r) {
                 ArrayList<String> ar1 = new ArrayList<String>();
                 ar1.addAll(ar);
                 r1.add(ar1);
             }
             map.put(s.substring(0, i + 1), r1);
         }
         return r;
    }
    private static boolean isPalindrome(String s) {
        if(s == null || s.equals("")) return false;
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
