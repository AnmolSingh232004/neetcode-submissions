class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<String>());
        return res;
    }

    public void backtrack(String s, int start, List<String> part) {
        if (start == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int end=start+1; end <= s.length(); end++) {
            if (isPalin(s, start, end-1)) {

            part.add(s.substring(start, end));
            backtrack(s, end, part);
            part.remove(part.size() - 1);

            }
        }
    }

    public boolean isPalin(String s, int lo, int hi) {
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi))return false;
            lo++;
            hi--;
        }
        return true;
    }
}

// we can make all possible partitions and if a partition is invalid we skip that branc
// we can use a for loop to call dfs on initial partitons ex : aab -> a, aa, aab
