public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0) {
            int val1 = index1 >= 0 ? a.charAt(index1--) - '0' : 0;
            int val2 = index2 >= 0 ? b.charAt(index2--) - '0' : 0;
            int sum = val1 + val2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
