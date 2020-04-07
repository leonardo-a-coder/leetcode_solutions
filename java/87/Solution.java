public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return isScramble(s1.toCharArray(), 0, s1.length() - 1, s2.toCharArray(), 0, s2.length() - 1, new HashMap<>());
    }
    
    private boolean isScramble(char[] s1, int start1, int end1, char[] s2, int start2, int end2, Map<Long, Boolean> cache) {
        long key = hash(s1.length + s2.length, start1, end1, start2, end2);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (isSame(s1, start1, end1, s2, start2, end2)) {
            cache.put(key, true);
            return true;
        } else if (!isAnagram(s1, start1, end1, s2, start2, end2)) {
            cache.put(key, false);
            return false;
        }
        for (int len = 0; len < end1 - start1; len++) {
            if ((isScramble(s1, start1, start1 + len, s2, start2, start2 + len, cache) &&
                    isScramble(s1, start1 + len + 1, end1, s2, start2 + len + 1, end2, cache)) ||
                (isScramble(s1, start1, start1 + len, s2, end2 - len, end2, cache) &&
                    isScramble(s1, start1 + len + 1, end1, s2, start2, end2 - len - 1, cache))) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }
    
    private boolean isSame(char[] s1, int start1, int end1, char[] s2, int start2, int end2) {
        while (start1 <= end1) {
            if (s1[start1++] != s2[start2++]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isAnagram(char[] s1, int start1, int end1, char[] s2, int start2, int end2) {
        int[] count = new int[128];
        while (start1 <= end1) {
            count[s1[start1++]]++;
            count[s2[start2++]]--;
        }
        for (int i = 0; i < 128; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    private long hash(int base, int... nums) {
        long result = 0;
        for (int num : nums) {
            result = result * base + num;
        }
        return result;
    }
}
