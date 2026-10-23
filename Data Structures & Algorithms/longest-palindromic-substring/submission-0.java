class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for (int i=0; i<s.length(); i++) {
            int lo = i;
            int hi = i;
            while (lo > -1 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                if (res.length() < hi - lo + 1) {
                    res = s.substring(lo, hi+1);
                }
                lo--;
                hi++;
            }
            lo = i;
            hi = i+1;
            while (lo > -1 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                if (res.length() < hi - lo + 1) {
                    res = s.substring(lo, hi+1);
                }
                lo--;
                hi++;
            }
        }
        return res;
    }
}
