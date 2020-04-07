public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        Integer[] arr = new Integer[rowIndex + 1];
        arr[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                arr[j] += arr[j - 1];
            }
            arr[i] = 1;
        }
        return Arrays.asList(arr);
    }
}
