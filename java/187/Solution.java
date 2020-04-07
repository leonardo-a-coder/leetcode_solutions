public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() <= 10) {
            return result;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < 9; i++) {
            cur <<= 2;
            cur |= encode(s.charAt(i));
        }
        for (int i = 9; i < s.length(); i++) {
            cur <<= 2;
            cur |= encode(s.charAt(i));
            cur &= 0xfffff;
            if (map.containsKey(cur)) {
                if (!map.get(cur)) {
                    result.add(s.substring(i - 9, i + 1));
                    map.put(cur, true);
                }
            } else {
                map.put(cur, false);
            }
        }
        return result;
    }
    
    private int encode(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                throw new IllegalArgumentException("Invalid character: " + c);
        }
    }
}
