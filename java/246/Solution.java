public class Solution {
    private static final Set<Character> SINGLE_STRO_SET;
    private static final Map<Character, Character> DOUBLE_STRO_MAP;
    static {
        Set<Character> tmpSet = new HashSet<>();
        tmpSet.add('0');
        tmpSet.add('1');
        tmpSet.add('8');
        SINGLE_STRO_SET = Collections.unmodifiableSet(tmpSet);
        Map<Character, Character> tmpMap = new HashMap<>();
        tmpMap.put('0', '0');
        tmpMap.put('1', '1');
        tmpMap.put('6', '9');
        tmpMap.put('8', '8');
        tmpMap.put('9', '6');
        DOUBLE_STRO_MAP = Collections.unmodifiableMap(tmpMap);
    }
    
    public boolean isStrobogrammatic(String num) {
        int start = 0;
        int end = num.length() - 1;
        while (start < end) {
            if (!DOUBLE_STRO_MAP.containsKey(num.charAt(start)) || DOUBLE_STRO_MAP.get(num.charAt(start)) != num.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return start == end ? SINGLE_STRO_SET.contains(num.charAt(start)) : true;
    }
}
