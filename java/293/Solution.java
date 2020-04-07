public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        int index = -1;
        while ((index = s.indexOf("++", index + 1)) >= 0) {
            result.add(new StringBuilder().append(s.substring(0, index)).append("--").append(s.substring(index + 2)).toString());
        }
        return result;
    }
}
