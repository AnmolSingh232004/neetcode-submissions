class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        for (Character alpha = 'A'; alpha <= 'Z'; alpha++) {
            int wrongCount = 0;
            int lo = 0;
            int hi = 0;
            while (hi < s.length()) {
                
                if (s.charAt(hi) == alpha) {
                    hi++;
                }
                else if (s.charAt(hi) != alpha && wrongCount <= k) {
                    hi++;
                    wrongCount++;
                }
                
                while (wrongCount > k && lo < hi) {
                    if (s.charAt(lo) != alpha) {
                        wrongCount--;
                        lo++;
                    } else {
                    lo++;
                    }
                }
                int winSize = hi - lo;
                res = Math.max(winSize, res);
                
            }
        }
        return res;
    }
}
