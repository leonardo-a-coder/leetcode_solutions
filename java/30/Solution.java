public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordDict = new HashMap<>();
        if (words.length == 0) {
            return result;
        }
        int numWords = words.length;
        int wordLen = words[0].length();
        int targetLen = numWords * wordLen;
        if (s.length() < targetLen) {
            return result;
        }
        for (String word : words) {
            Integer val = wordDict.get(word);
            wordDict.put(word, val == null ? 1 : val + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int start = i;
            Map<String, Integer> visited = new HashMap<>();
            for (int j = i; j + wordLen <= s.length(); j += wordLen) {
                String cur = s.substring(j, j + wordLen);
                if (!wordDict.containsKey(cur)) {
                    start = j + wordLen;
                    visited.clear();
                } else {
                    if (visited.containsKey(cur) && visited.get(cur) == wordDict.get(cur)) {
                        while (true) {
                            String remove = s.substring(start, start + wordLen);
                            start += wordLen;
                            int val = visited.get(remove);
                            if (val == 1) {
                                visited.remove(remove);
                            } else {
                                visited.put(remove, val - 1);
                            }
                            if (remove.equals(cur)) {
                                break;
                            }
                        }
                    }
                    Integer val = visited.get(cur);
                    visited.put(cur, val == null ? 1 : val + 1);
                    if (j + wordLen - start == targetLen) {
                        result.add(start);
                    }
                }
            }
        }
        return result;
    }
}
