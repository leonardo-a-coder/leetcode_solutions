public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        restoreIp(s.toCharArray(), 1, result, new ArrayList<>(), s.charAt(0) - '0');
        return result;
    }
    
    private void restoreIp(char[] s, int index, List<String> result, List<Integer> cur, int num) {
        if (index == s.length) {
            if (cur.size() == 3) {
                cur.add(num);
                result.add(convertIp(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int curNum = s[index] - '0';
        int next = num * 10 + curNum;
        if (num != 0 && next < 256) {
            restoreIp(s, index + 1, result, cur, next);
        }
        if (s.length - index <= (4 - cur.size() - 1) * 3) {
            cur.add(num);
            restoreIp(s, index + 1, result, cur, curNum);
            cur.remove(cur.size() - 1);
        }
    }
    
    private String convertIp(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums.get(0));
        for (int i = 1; i < 4; i++) {
            sb.append('.').append(nums.get(i));
        }
        return sb.toString();
    }
}
