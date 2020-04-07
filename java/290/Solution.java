public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        String[] mapping = new String[26];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if (mapping[index] == null) {
                if (!visited.contains(words[i])) {
                    mapping[index] = words[i];
                    visited.add(words[i]);
                } else {
                    return false;
                }
            } else if (!mapping[index].equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
