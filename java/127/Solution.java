public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int result = 1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmpSet = beginSet;
                beginSet = endSet;
                endSet = tmpSet;
            }
            Set<String> curSet = new HashSet<>();
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char origin = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);
                        if (endSet.contains(newWord)) {
                            return ++result;
                        } else if (wordList.contains(newWord)) {
                            curSet.add(newWord);
                            wordList.remove(newWord);
                        }
                    }
                    arr[i] = origin;
                }
            }
            beginSet = curSet;
            result++;
        }
        return 0;
    }
}
