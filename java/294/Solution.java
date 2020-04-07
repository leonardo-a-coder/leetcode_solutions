public class Solution {
    public boolean canWin(String s) {
        return canWin(s, new HashMap<>());
    }
    
    public boolean canWin(String s, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        int index = -1;
        while ((index = s.indexOf("++", index + 1)) >= 0) {
            String next = new StringBuilder().append(s.substring(0, index)).append("--").append(s.substring(index + 2)).toString();
            if (!canWin(next, cache)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }
}
