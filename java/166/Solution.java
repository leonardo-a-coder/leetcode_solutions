public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (denominator == 0) {
            return "";
        }
        long longNumerator = Math.abs((long) numerator);
        long longDenominator = Math.abs((long) denominator);
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append('-');
        }
        sb.append(longNumerator / longDenominator);
        longNumerator %= longDenominator;
        if (longNumerator != 0) {
            sb.append('.').append(calculateFraction(longNumerator, longDenominator));
        }
        return sb.toString();
    }
    
    private String calculateFraction(long remainder, long denominator) {
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> remainderMap = new HashMap<>();
        int index = 0;
        while (remainder > 0) {
            remainder *= 10;
            if (remainderMap.containsKey(remainder)) {
                sb.insert(remainderMap.get(remainder), "(");
                sb.append(')');
                return sb.toString();
            }
            remainderMap.put(remainder, index++);
            sb.append(remainder / denominator);
            remainder = remainder % denominator;
        }
        return sb.toString();
    }
}
