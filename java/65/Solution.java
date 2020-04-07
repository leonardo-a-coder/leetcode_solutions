import java.util.regex.Pattern;

public class Solution {
    public boolean isNumber(String s) {
        String regex = "[+-]?(\\d+\\.?|\\.\\d+)\\d*(e[+-]?\\d+)?";
        return Pattern.matches(regex, s.trim());
    }
}
