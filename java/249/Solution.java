public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strings) {
            String key = toKey(word);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        for (List<String> value : map.values()) {
            Collections.sort(value);
            result.add(value);
        }
        return result;
    }
    
    private String toKey(String word) {
        if (word.length() == 0 || word.charAt(0) == 'a') {
            return word;
        }
        char[] arr = new char[word.length()];
        arr[0] = 'a';
        int diff = word.charAt(0) - 'a';
        for (int i = 1; i < word.length(); i++) {
            arr[i] = (char) ('a' + (word.charAt(i) - 'a' - diff + 26) % 26);
        }
        return new String(arr);
    }
}
