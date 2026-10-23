class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long maxPile = 0L;
        for (int i=0; i<piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }

        for (int k=1; k<=maxPile; k++) {
            long totalTimeTaken = 0L;

        for (int i=0; i<piles.length; i++) {
            long timeTaken = (long) Math.ceil( (double) piles[i] / (double) k);

            totalTimeTaken += timeTaken;  // 2.2, 0.9, 2.1, 0.3  || 
        }
        if (totalTimeTaken <= h)return k;
        }

        return -69;
    }
}

// Input: piles = [25,10,23,4], h = 4

// Output: 25
