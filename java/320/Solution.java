public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        generateAbbr(word, 0, result, new StringBuilder(), false);
        return result;
    }
    
    private void generateAbbr(String word, int index, List<String> result, StringBuilder sb, boolean lastAbbr) {
        if (index == word.length()) {
            result.add(sb.toString());
            return;
        }
        int len = sb.length();
        sb.append(word.charAt(index));
        generateAbbr(word, index + 1, result, sb, false);
        sb.setLength(len);
        if (!lastAbbr) {
            for (int i = index; i < word.length(); i++) {
                sb.append(i - index + 1);
                generateAbbr(word, i + 1, result, sb, true);
                sb.setLength(len);
            }
        }
    }
}
