public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < words.length) {
            int len = 0;
            while (end < words.length && len + words[end].length() <= maxWidth) {
                len += words[end++].length() + 1;
            }
            len--;
            StringBuilder sb = new StringBuilder();
            if (end == words.length || end - start == 1) {
                for (int i = start; i < end; i++) {
                    sb.append(words[i]).append(' ');
                }
                sb.setLength(sb.length() - 1);
                addSpaces(sb, maxWidth - sb.length());
            } else {
                int numIntervals = end - start - 1;
                int spaces = numIntervals + (maxWidth - len);
                for (int i = start; i < end - 1; i++) {
                    sb.append(words[i]);
                    addSpaces(sb, spaces / numIntervals + (spaces % numIntervals > i - start ? 1 : 0));
                }
                sb.append(words[end - 1]);
            }
            start = end;
            result.add(sb.toString());
        }
        return result;
    }
    
    private void addSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }
}
