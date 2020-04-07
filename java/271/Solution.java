public class Codec {
    private static final Character DELIMITER = '#';

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int len = 0;
            while (index < s.length() && s.charAt(index) != DELIMITER) {
                len = len * 10 + (s.charAt(index) - '0');
                index++;
            }
            index++;
            result.add(s.substring(index, index + len));
            index += len;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
