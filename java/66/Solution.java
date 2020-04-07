public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;
        while (carry > 0 && index >= 0) {
            int sum = digits[index] + carry;
            digits[index] = sum % 10;
            carry = sum / 10;
            index--;
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
