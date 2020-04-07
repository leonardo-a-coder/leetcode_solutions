public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftRemove++;
            } else if (c == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }
        remove(s, 0, result, new StringBuilder(), leftRemove, rightRemove, 0, false);
        return result;
    }
    
    private void remove(String s, int index, List<String> result, StringBuilder sb, int leftRemove, int rightRemove, int diff, boolean lastRemoved) {
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && diff == 0) {
                result.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        int len = sb.length();
        if (c == '(') {
            if (leftRemove > 0) {
                remove(s, index + 1, result, sb, leftRemove - 1, rightRemove, diff, true);
            }
            if (index == 0 || c != s.charAt(index - 1) || !lastRemoved) {
                sb.append(c);
                remove(s, index + 1, result, sb, leftRemove, rightRemove, diff + 1, false);
                sb.setLength(len);
            }
        } else if (c == ')') {
            if (rightRemove > 0) {
                remove(s, index + 1, result, sb, leftRemove, rightRemove - 1, diff, true);
            }
            if (diff > 0 && (index == 0 || c != s.charAt(index - 1) || !lastRemoved)) {
                sb.append(c);
                remove(s, index + 1, result, sb, leftRemove, rightRemove, diff - 1, false);
                sb.setLength(len);
            }
        } else {
            sb.append(c);
            remove(s, index + 1, result, sb, leftRemove, rightRemove, diff, lastRemoved);
            sb.setLength(len);
        }
    }
}
