import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        /*
            read into a stack
            if operator, pop 2, calc and push 1
            
            O(n) O(n)
        */
        
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < tokens.length; i++) {
            if(!isOperator(tokens[i])) {
                stack.push(tokens[i]);
            }
            else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int c = 0;
                switch(tokens[i]) {
                    case "+": c = a + b; break;
                    case "-": c = a - b; break;
                    case "*": c = a * b; break;
                    case "/": c = a / b; break;
                }
                stack.push((new Integer(c)).toString());
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
    
    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
