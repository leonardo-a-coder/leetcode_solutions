public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] arr = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            for (int j = 0; j < len2; j++) {
                int sum = n1 * (num2.charAt(j) - '0') + arr[i + j] + carry;
                arr[i + j] = sum % 10;
                carry = sum / 10;
            }
            arr[i + len2] += carry;
        }
        int end = arr.length - 1;
        while (end > 0 && arr[end] == 0) {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
