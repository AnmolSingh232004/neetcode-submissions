class Solution {
    public int characterReplacement(String s, int k) {

        int res = 0;

        for (Character currChar = 'A'; currChar<='Z'; currChar++) {
            int wrongCount = 0;
            int lo = 0;
            int hi = 0;

            while (hi < s.length()) {

                if (s.charAt(hi) != currChar && wrongCount <= k) { // not same char encounter
                    hi++;
                    wrongCount++;
                }
                else if (s.charAt(hi) == currChar) { // same as currChar encounter
                    hi++;
                }

                while (wrongCount > k && lo < hi) {
                    if (s.charAt(lo) != currChar) {
                        wrongCount--;
                    }
                    lo++;
                }

                int winSize = hi - lo;
                res = Math.max(winSize, res);
            }
        }
        return res;
    }
}

// for every character we can itterate once so for A one whole s, for B one whoel s
// we make a sliding window 
// it should be valid every time
// dynamic sliding window we can have a wrongCount counter
