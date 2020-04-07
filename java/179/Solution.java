public class Solution {
    public String largestNumber(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return generateResult(nums);
    }
    
    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int index = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (compare(nums[left], nums[right]) >= 0) {
                tmp[index++] = nums[left++];
            } else {
                tmp[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            tmp[index++] = nums[left++];
        }
        for (int i = 0; i < index; i++) {
            nums[start++] = tmp[i];
        }
    }
    
    private int compare(Integer num1, Integer num2) {
        String str1 = new StringBuilder().append(num1).append(num2).toString();
        String str2 = new StringBuilder().append(num2).append(num1).toString();
        return str1.compareTo(str2);
    }
    
    private String generateResult(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        int start = 0;
        while (start < sb.length() - 1 && sb.charAt(start) == '0') {
            start++;
        }
        return sb.substring(start);
    }
}
