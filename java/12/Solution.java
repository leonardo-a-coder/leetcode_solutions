public class Solution {
    private static final String[] ROMAN = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] INTEGERS = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            while (num >= INTEGERS[index]) {
                sb.append(ROMAN[index]);
                num -= INTEGERS[index];
            }
            index++;
        }
        return sb.toString();
    }
}
