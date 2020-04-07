public class Solution {
    private static final String[] PHONE_NUMBERS = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        letterCombinations(digits, 0, result, new StringBuilder());
        return result;
    }
    
    private void letterCombinations(String digits, int index, List<String> result, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char c : PHONE_NUMBERS[digits.charAt(index) - '2'].toCharArray()) {
            sb.append(c);
            letterCombinations(digits, index + 1, result, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
