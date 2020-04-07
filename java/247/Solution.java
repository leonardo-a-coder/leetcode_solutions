public class Solution {
    public static final char[] SINGLE_STROBO = new char[] {'0', '1', '8'};
    public static final char[][] DOUBLE_STROBO = new char[][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        findStrobo(new char[n], 0, n - 1, result);
        return result;
    }
    
    private void findStrobo(char[] arr, int start, int end, List<String> result) {
        if (start > end) {
            result.add(new String(arr));
            return;
        } else if (start == end) {
            for (char c : SINGLE_STROBO) {
                arr[start] = c;
                result.add(new String(arr));
            }
            return;
        }
        for (char[] pair : DOUBLE_STROBO) {
            arr[start] = pair[0];
            arr[end] = pair[1];
            if (start > 0 || pair[0] != '0') {
                findStrobo(arr, start + 1, end - 1, result);
            }
        }
    }
}
