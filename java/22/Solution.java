public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new char[n << 1], 0, n, n);
        return result;
    }
    
    private void generate(List<String> result, char[] arr, int index, int left, int right) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        
        if (left > 0) {
            arr[index] = '(';
            generate(result, arr, index + 1, left - 1, right);
        }
        if (right > left) {
            arr[index] = ')';
            generate(result, arr, index + 1, left, right - 1);
        }
    }
}
