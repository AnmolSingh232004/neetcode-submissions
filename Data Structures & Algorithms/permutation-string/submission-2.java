class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())return false;
        Map<Character, Integer> s1Freq = new HashMap<>();
        Map<Character, Integer> s2Freq = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            s1Freq.put(s1.charAt(i), s1Freq.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i=0; i<s1.length(); i++) {
            s2Freq.put(s2.charAt(i), s2Freq.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (isMapEqual(s1Freq, s2Freq))return true;

        int hi = s1.length();
        int lo = 0;

        while (hi < s2.length() && lo < s2.length()) {
            s2Freq.put(s2.charAt(hi), s2Freq.getOrDefault(s2.charAt(hi), 0) + 1);

            if (s2Freq.containsKey(s2.charAt(lo)) && s2Freq.get(s2.charAt(lo) ) == 1) {
                s2Freq.remove(s2.charAt(lo));
            } else {
                s2Freq.put(s2.charAt(lo), s2Freq.get(s2.charAt(lo)) - 1);
            }

            if (isMapEqual(s1Freq, s2Freq))return true;

            hi++;
            lo++;
        }
        return false;
    }

    public boolean isMapEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size())return false;

        for (Character c : map1.keySet()) {
            if (map2.get(c) != map1.get(c))return false;
        }
        return true;
    }
}

// static window of size s1
// itterate over s2 until a frequency match is found
// lets use a hasmap to compare frequencies
// first we build frequency of s1 in map 1
// then our window will itterate over s2 and find frequency mathch, if found return true else false

