public class Solution {
    private static final String[] TENS = new String[] {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] NUMS = new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    public String numberToWords(int num) {
        if (num < 0) {
            return "";
        } else if (num == 0) {
            return "Zero";
        } else {
            return numToWord(num).substring(1);
        }
    }
    
    private String numToWord(int num) {
        if (num >= 1000000000) {
            return new StringBuilder().append(numToWord(num / 1000000000)).append(" Billion").append(numToWord(num % 1000000000)).toString();
        } else if (num >= 1000000) {
            return new StringBuilder().append(numToWord(num / 1000000)).append(" Million").append(numToWord(num % 1000000)).toString();
        } else if (num >= 1000) {
            return new StringBuilder().append(numToWord(num / 1000)).append(" Thousand").append(numToWord(num % 1000)).toString();
        } else if (num >= 100) {
            return new StringBuilder().append(numToWord(num / 100)).append(" Hundred").append(numToWord(num % 100)).toString();
        } else if (num >= 20) {
            return new StringBuilder().append(' ').append(TENS[num / 10 - 2]).append(numToWord(num % 10)).toString();
        } else if (num > 0) {
            return new StringBuilder().append(' ').append(NUMS[num - 1]).toString();
        } else {
            return "";
        }
    }
}
