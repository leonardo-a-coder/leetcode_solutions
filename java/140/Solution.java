public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        wordBreak(s, wordDict, result, new ArrayList<>(), new HashMap<>(), 0);
        return result;
    }
    
    private boolean wordBreak(String s, Set<String> wordDict, List<String> result, List<String> cur, Map<Integer, List<String>> nextMap, int index) {
        if (s.length() == 0) {
            result.add(generateResult(cur));
            return true;
        }
        if (nextMap.containsKey(index)) {
            List<String> nextList = nextMap.get(index);
            if (nextList == null) {
                return false;
            }
            for (String nextWord : nextList) {
                cur.add(nextWord);
                wordBreak(s.substring(nextWord.length()), wordDict, result, cur, nextMap, index + nextWord.length());
                cur.remove(cur.size() - 1);
            }
            return true;
        }
        List<String> nextList = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                cur.add(word);
                if (wordBreak(s.substring(word.length()), wordDict, result, cur, nextMap, index + word.length())) {
                    nextList.add(word);
                }
                cur.remove(cur.size() - 1);
            }
        }
        if (nextList.isEmpty()) {
            nextMap.put(index, null);
            return false;
        } else {
            nextMap.put(index, nextList);
            return true;
        }
    }
    
    private String generateResult(List<String> cur) {
        if (cur.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cur.get(0));
        for (int i = 1; i < cur.size(); i++) {
            sb.append(' ').append(cur.get(i));
        }
        return sb.toString();
    }
}
