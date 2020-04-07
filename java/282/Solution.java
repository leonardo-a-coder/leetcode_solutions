public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperators(num, target, 0, result, new StringBuilder(), 0, 0);
        return result;
    }
    
    private void addOperators(String num, long target, int index, List<String> result, StringBuilder sb, long curNum, long lastNum) {
        if (index == num.length()) {
            if (curNum == target) {
                result.add(sb.toString());
            }
            return;
        }
        int len = sb.length();
        long cur = 0;
        for (int i = index; i < num.length(); i++) {
            cur = cur * 10 + num.charAt(i) - '0';
            if (len == 0) {
                addOperators(num, target, i + 1, result, sb.append(cur), cur, cur);
                sb.setLength(len);
            } else {
                addOperators(num, target, i + 1, result, sb.append('+').append(cur), curNum + cur, cur);
                sb.setLength(len);
                addOperators(num, target, i + 1, result, sb.append('-').append(cur), curNum - cur, -cur);
                sb.setLength(len);
                addOperators(num, target, i + 1, result, sb.append('*').append(cur), curNum - lastNum + lastNum * cur, lastNum * cur);
                sb.setLength(len);
            }
            if (num.charAt(index) == '0') {
                break;
            }
        }
    }
}
