import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        /**
         * seperate with / and get an array
         * if empty or . ignore
         * if .. pop
         * else push
         * 
         * O(n) O(n)
         */
         
         if(path == null) return null;
         
         String[] sa = path.split("/");
         Stack<String> stack = new Stack<String>();
         for(int i = 0; i < sa.length; i++) {
             String s = sa[i];
             if(s.length() == 0 || s.equals(".")) continue;
             else if(s.equals("..")) {
                 if(!stack.isEmpty()) stack.pop();
             }
             else {
                 stack.push(s);
             }
         }
         String r = "";
         while(!stack.isEmpty()) {
             String d = stack.pop();
             r = d + r;
             r = "/" + r;
         }
         
         if(r == "") return "/";
         else return r;
    }
}
