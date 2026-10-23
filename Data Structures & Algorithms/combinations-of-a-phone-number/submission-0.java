class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        map.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        map.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        map.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        map.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        map.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        map.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        map.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));


        backtrack(digits, 0, new StringBuilder());
        return res;

    }

    public void backtrack(String digits, int start, StringBuilder comb) {
        if (digits.length() == 0) {
            res = new ArrayList<String>();
            return;
        }
        if (comb.length() == digits.length()) {
            res.add(new String(comb));
            return;
        }

        List<Character> alphabets = map.get(digits.charAt(start));
        for (int i=0; i<alphabets.size(); i++) {
            comb.append(alphabets.get(i));
            backtrack(digits, start+1, comb);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}

// first character will always be from the first digit
// every character in any combination will only be from its respective digit's position

// if our stringbuilder reachces length od digits it means a valid combo is found so we store
// we start a loop which will start from 1st element of the corresponding digits, so for 2 it will be itterate of list of key 2 which is a,b,c
// and we just backtrack for it 
// so we for "23", since we start list of 2, we add 'a' to string builder and backtrack for start+1, which then moves to '3' and then we make all possible combos of 'a' for all values in list of '3' which is 'd','e','f', then the backtrack ends then we move onto b for b do same for 'd','e','f'