class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            char[] charA = strs[i].toCharArray();
            Arrays.sort(charA);
            String sorted = new String(charA);

            if (!map.containsKey(sorted)) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(sorted, newList);
            } else {
                List<String> updatedList = map.get(sorted);
                updatedList.add(strs[i]);
                map.put(sorted, updatedList);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}

// we can convert each string into char array and then sort it and store it as key and all anagrams of it as value

// we convert into char array -> sort -> reconvert into string -> store anagram as key -> store value as the string itself
