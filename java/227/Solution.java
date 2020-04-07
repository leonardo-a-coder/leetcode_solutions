public class Solution {
    public int calculate(String s) {
        int left = 0;
        int right = 0;
        boolean isPositive = true;
        Operator lastOp = null;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    cur = cur * 10 + s.charAt(j++) - '0';
                }
                i = j - 1;
                if (lastOp == Operator.MULTIPLY) {
                    right *= cur;
                } else if (lastOp == Operator.DIVIDE) {
                    right /= cur;
                } else {
                    right = cur;
                }
            } else if (c == '+' || c == '-') {
                left += isPositive ? right : -right;
                isPositive = c == '+';
                lastOp = c == '+' ? Operator.ADD : Operator.MINUS;
            } else if (c == '*') {
                lastOp = Operator.MULTIPLY;
            } else if (c == '/') {
                lastOp = Operator.DIVIDE;
            }
        }
        left += isPositive ? right : -right;
        return left;
    }
    
    enum Operator {
        ADD, MINUS, MULTIPLY, DIVIDE
    }
}
