public class Solution {
    public String getHint(String secret, String guess) {
        int numBulls = 0;
        int numCows = 0;
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                numBulls++;
            }
            countSecret[cs - '0']++;
            countGuess[cg - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            numCows += Math.min(countSecret[i], countGuess[i]);
        }
        numCows -= numBulls;
        return new StringBuilder().append(numBulls).append('A').append(numCows).append('B').toString();
    }
}
