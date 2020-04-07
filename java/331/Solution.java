public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        int count = 0;
        int index = 0;
        while (index < tokens.length) {
            if (tokens[index++].equals("#")) {
                count--;
                if (count < 0) {
                    break;
                }
            } else {
                count++;
            }
        }
        return count == -1 && index == tokens.length;
    }
}
