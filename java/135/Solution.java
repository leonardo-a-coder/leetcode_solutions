public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 0) {
            return 0;
        }
        int result = 1;
        int lastValue = 1;
        int peakIndex = 0;
        int peakValue = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result += ++lastValue;
                peakIndex = i;
                peakValue = lastValue;
            } else if (ratings[i] < ratings[i - 1]) {
                if (lastValue == 1) {
                    if (peakValue == i - peakIndex) {
                        result += ++peakValue;
                    } else {
                        result += i - peakIndex;
                    }
                } else {
                    lastValue = 1;
                    result++;
                }
            } else {
                lastValue = 1;
                result++;
                peakIndex = i;
                peakValue = 1;
            }
        }
        return result;
    }
}
