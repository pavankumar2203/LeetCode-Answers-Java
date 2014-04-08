import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        /*
            use a stack
            for each char c:
                if stack is empty or c doesnt match with top e in stack:
                    push c to stack
                if c match with top e in stack:
                    pop stack
            return stack is empty
            
            O(n) O(n)
        */
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.empty()) {
                stack.push(c);
            }
            else {
                char top = stack.peek();
                if(top == '(' && c == ')' || top == '{' && c == '}' || top == '[' && c == ']') {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }
        
        return stack.empty();
    }
}
