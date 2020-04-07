public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Map<String, List<String>> nextMap = new HashMap<>();
        boolean isReversed = false;
        
        wordList.remove(beginWord);
        wordList.remove(endWord);
        beginSet.add(beginWord);
        endSet.add(endWord);
        nextMap.put(beginWord, new ArrayList<>());
        for (String word : wordList) {
            nextMap.put(word, new ArrayList<>());
        }
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                isReversed = !isReversed;
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            boolean isFound = false;
            Set<String> curSet = new HashSet<>();
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char origin = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);
                        if (endSet.contains(newWord)) {
                            isFound = true;
                        }
                        if (endSet.contains(newWord) || wordList.contains(newWord)) {
                            curSet.add(newWord);
                            if (isReversed) {
                                nextMap.get(newWord).add(word);
                            } else {
                                nextMap.get(word).add(newWord);
                            }
                        }
                    }
                    arr[i] = origin;
                }
            }
            if (isFound) {
                break;
            }
            wordList.removeAll(curSet);
            beginSet = curSet;
        }
        generateResult(result, nextMap, new ArrayList<>(), beginWord, endWord);
        return result;
    }
    
    private void generateResult(List<List<String>> result, Map<String, List<String>> nextMap, List<String> path, String curWord, String endWord) {
        path.add(curWord);
        if (curWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (String next : nextMap.get(curWord)) {
            generateResult(result, nextMap, path, next, endWord);
        }
        path.remove(path.size() - 1);
    }
}
