class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0; // upper bound for how much koko can eat
        for (int i=0; i<piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }

        int lo = 1;
        int hi = maxPile;

        int res = maxPile;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // mid is basically speed of koko eating aka k
            
            long totalTimeTaken = 0L; // total time taken is basically how long it takes to eat all bananas for a k

        for (int i=0; i<piles.length; i++) { // calc if mid is able to eat bannana in time or not
            long timeTaken = (long) Math.ceil( (double) piles[i] / (double) mid); 
            // double cast because we want the double value to be fed to Math.ceil() which will round it off to the bigger one

            totalTimeTaken += timeTaken;  // calculating time taken to eat for each k / mid
        }
        if (totalTimeTaken > h) { // not enough speed of eating this means we need a bigger value than mid 
        lo = mid + 1;

        } else if (totalTimeTaken <= h) { // ate in enough time
        res = (int) Math.min(res, mid); // This is the impt part, we update res until we find absoulte min value which satisfies the hour limit
        hi = mid - 1;
        }
        
        }
        return res;
    }
}

// Input: piles = [25,10,23,4], h = 4

// Output: 25

// [1,2,3,4,5,6,7,8,9,10,11] mid = 6