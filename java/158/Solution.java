public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    private char[] buffer;
    private int start;
    private int end;
    
    public Solution() {
        buffer = new char[4];
    }
    
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            while (index < n && start < end) {
                buf[index++] = buffer[start++];
            }
            if (index == n) {
                return n;
            }
            start = 0;
            end = read4(buffer);
            if (end == 0) {
                return index;
            }
        }
        return index;
    }
}
