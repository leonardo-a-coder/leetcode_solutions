public class WordDistance {
    private Map<String, List<Integer>> wordIndexMap;

    public WordDistance(String[] words) {
        wordIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!wordIndexMap.containsKey(words[i])) {
                wordIndexMap.put(words[i], new ArrayList<>());
            }
            wordIndexMap.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = wordIndexMap.get(word1);
        List<Integer> indices2 = wordIndexMap.get(word2);
        int index1 = 0;
        int index2 = 0;
        int result = Integer.MAX_VALUE;
        while (index1 < indices1.size() && index2 < indices2.size()) {
            int i1 = indices1.get(index1);
            int i2 = indices2.get(index2);
            if (i1 < i2) {
                result = Math.min(result, i2 - i1);
                index1++;
            } else {
                result = Math.min(result, i1 - i2);
                index2++;
            }
        }
        return result;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
