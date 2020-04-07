public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        int start = 0;
        int end = 0;
        int len = path.length();
        while (end < len) {
            while (end < len && path.charAt(end) != '/') {
                end++;
            }
            if (start != end) {
                String cur = path.substring(start, end);
                if (cur.equals("..")) {
                    if (!list.isEmpty()) {
                        list.removeLast();
                    }
                } else if (!cur.equals(".")) {
                    list.add(cur);
                }
            }
            start = ++end;
        }
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            sb.append('/').append(list.poll());
        }
        return sb.toString();
    }
}
