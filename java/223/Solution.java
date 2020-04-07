public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (int) (computeArea(A, B, C, D) + computeArea(E, F, G, H) - 
            computeArea(Math.max(A, E), Math.max(B, F), Math.min(C, G), Math.min(D, H)));
    }
    
    private long computeArea(long A, long B, long C, long D) {
        return Math.max(C - A, 0) * Math.max(D - B, 0);
    }
}
