public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        } else if (k <= 0) {
            return 0;
        }
        int result = 0;
        SortedSet<Integer> set = new TreeSet<>();
        int[] lastIndex = new int[128];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastIndex[c] == 0) {
                if (k == 0) {
                    result = Math.max(result, i - start);
                    int remove = set.first();
                    set.remove(remove);
                    start = remove + 1;
                    lastIndex[s.charAt(remove)] = 0;
                    k++;
                }
                k--;
            } else {
                set.remove(lastIndex[c] - 1);
            }
            set.add(i);
            lastIndex[c] = i + 1;
        }
        result = Math.max(result, s.length() - start);
        return result;
    }
}
