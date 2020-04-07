public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 0; i < num.length() >> 1; i++) {
            for (int j = i + 1; j < num.length() / 3 * 2; j++) {
                if (isAdditiveNumber(num.substring(0, i + 1), num.substring(i + 1, j + 1), num.substring(j + 1))) {
                    return true;
                }
                if (num.charAt(i + 1) == '0') {
                    break;
                }
            }
            if (num.charAt(0) == '0') {
                break;
            }
        }
        return false;
    }
    
    private boolean isAdditiveNumber(String num1, String num2, String remaining) {
        if (remaining.length() == 0) {
            return true;
        }
        String sum = add(num1, num2);
        if (!remaining.startsWith(sum)) {
            return false;
        }
        return isAdditiveNumber(num2, sum, remaining.substring(sum.length()));
    }
    
    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int cur1 = index1 >= 0 ? num1.charAt(index1--) - '0' : 0;
            int cur2 = index2 >= 0 ? num2.charAt(index2--) - '0' : 0;
            int sum = cur1 + cur2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
