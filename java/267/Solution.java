public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        int[] count = countChars(s);
        Character mid = null;
        for (int i = 0; i < 128; i++) {
            if ((count[i] & 1) == 1) {
                if (mid == null) {
                    mid = (char) i;
                    count[i]--;
                } else {
                    return result;
                }
            }
        }
        return generateFull(count, mid);
    }
    
    private List<String> generateFull(int[] count, Character mid) {
        List<String> result = new ArrayList<>();
        List<String> halves = generateHalves(count, 0);
        for (String half : halves) {
            StringBuilder sb = new StringBuilder();
            sb.append(half).reverse();
            if (mid != null) {
                sb.append(mid);
            }
            sb.append(half);
            result.add(sb.toString());
        }
        return result;
    }
    
    private List<String> generateHalves(int[] count, int countIndex) {
        List<String> result = new ArrayList<>();
        while (countIndex < count.length && count[countIndex] == 0) {
            countIndex++;
        }
        if (countIndex == count.length) {
            result.add("");
            return result;
        }
        count[countIndex] -= 2;
        for (String next : generateHalves(count, countIndex)) {
            for (int i = 0; i <= next.length(); i++) {
                result.add(new StringBuilder().append(next.substring(0, i)).append((char) countIndex).append(next.substring(i)).toString());
                if (i < next.length() && next.charAt(i) == countIndex) {
                    break;
                }
            }
        }
        return result;
    }
    
    private int[] countChars(String s) {
        int[] result = new int[128];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i)]++;
        }
        return result;
    }
}
