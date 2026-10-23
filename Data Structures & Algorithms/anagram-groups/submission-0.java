class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        // holds frequency of anagram as key and value as the anagram itself

        for (int i=0; i<strs.length; i++) {
            List<Integer> freq = new ArrayList<>(26);
            for (int k=0; k<26; k++) {
            freq.add(0);
            }

            for (int j=0; j<strs[i].length(); j++) {
                int currFreq = freq.get(strs[i].charAt(j) - 'a');
                freq.set(strs[i].charAt(j) - 'a', currFreq+1); 
            }

            if (map.containsKey(freq)) {
                List<String> updated = map.get(freq);
                updated.add(strs[i]);
                map.put(freq, updated);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(freq, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<Integer> key : map.keySet()) {
            List<String> finalList = map.get(key);
            res.add(finalList);
        }

        return res;
    }
}


// we can map frequency of characters for every string and map it to the string
// if corresponding frequency matches in that case simply add that string into group of anagram

// we can make a frequency map of every string, and map every anagram with that frequency code to the value in hash map