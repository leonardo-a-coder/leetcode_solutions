public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int len = 0;
        char[] buf4 = new char[4];
        while (len < n) {
            int cur = read4(buf4);
            if (cur == 0) {
                return len;
            }
            for (int i = 0; i < cur && len < n; i++) {
                buf[len++] = buf4[i];
            }
        }
        return n;
    }
}
