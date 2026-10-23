class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i=0; i<s.length(); i++) {

            int lo = i;
            int hi = i;

            while (hi < s.length() && lo < s.length()) {
                if ( isPalin(s, lo, hi) ) {
                    res++;
                }
                if (hi == s.length()) {
                    lo++;
                    hi = lo;
                }
                hi++;
            }
            
        }
        return res;
    }

    public boolean isPalin(String s, int lo, int hi) {
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi))return false;
            hi--;
            lo++;
        }
        return true;
    }
}
