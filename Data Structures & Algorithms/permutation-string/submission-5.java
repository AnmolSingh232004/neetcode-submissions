class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())return false; // if s1 is bigger than s2

        int[] required = new int[26]; // freq of s1
        int[] window = new int[26]; // freq of win built by s2

        for (int i=0; i<s1.length(); i++) { // update freq of required
            required[ Math.abs(s1.charAt(i) - 'a')]++;
        }

        for (int i=0; i<s1.length(); i++) { // initial window freq
            window[ Math.abs(s2.charAt(i) - 'a')]++;
        }

        if (Arrays.equals(required, window))return true;

        int lo = 0;
        int hi = s1.length()-1;
        hi++;

        while (hi < s2.length()) {
            window[Math.abs(s2.charAt(hi)) - 'a']++;
            window[Math.abs(s2.charAt(lo)) - 'a']--;
            hi++;
            lo++;

            if (Arrays.equals(required, window))return true;
        }

        return false;
    }
}
