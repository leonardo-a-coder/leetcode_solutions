public class Solution {
    public static final Map<Character, Integer> ROMAN_MAP;
    static {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        ROMAN_MAP = Collections.unmodifiableMap(map);
    }
    
    public int romanToInt(String s) {
        int result = 0;
        char[] arr = s.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        int prev = Integer.MAX_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur = ROMAN_MAP.get(arr[i]);
            if (cur > prev) {
                result = result - (prev << 1) + cur;
            } else {
                result += cur;
            }
            prev = cur;
        }
        return result;
    }
}
