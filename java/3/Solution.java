public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (map.containsKey(c) && start <= map.get(c)) {
                result = Math.max(result, i - start);
                start = map.get(c) + 1;
            }
            map.put(c, i);
        }
        result = Math.max(result, arr.length - start);
        return result;
    }
}
