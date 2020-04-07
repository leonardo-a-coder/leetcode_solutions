import java.util.SortedMap;

public class Solution {
    public String rearrangeString(String str, int k) {
        if (str.length() < 2 || k <= 1) {
            return str;
        }
        char[] result = new char[str.length()];
        SortedMap<Integer, List<Character>> map = new TreeMap<>(Collections.reverseOrder());

        buildMap(map, str);
        int cycle = 0;
        int index = 0;
        for (int key : map.keySet()) {
            Iterator<Character> iter = map.get(key).iterator();
            while (iter.hasNext()) {
                char c = iter.next();
                for (int i = 0; i < key; i++) {
                    if (index > 0 && result[index - 1] == c) {
                        return "";
                    }
                    result[index] = c;
                    index += k;
                    if (index >= result.length) {
                        index = ++cycle;
                    }
                }
            }
        }
        return new String(result);
    }
    
    private void buildMap(SortedMap<Integer, List<Character>> map, String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (!map.containsKey(count[i])) {
                    map.put(count[i], new ArrayList<>());
                }
                map.get(count[i]).add((char) (i + 'a'));
            }
        }
    }
}
