public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperand(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(calculate(left, right, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private boolean isOperand(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private int calculate(int left, int right, String token) {
        switch (token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return 0;
        }
    }
}
