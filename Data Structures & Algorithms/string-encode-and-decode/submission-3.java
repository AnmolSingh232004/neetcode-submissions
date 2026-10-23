class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder(); //construct the string we want to return (combined words and len and delimiter)
        for (int i=0; i<strs.size(); i++) {
            sb.append(strs.get(i).length()); // size of word
            sb.append('-'); // delimiter 
            for (int j=0; j<strs.get(i).length(); j++) { //word itself
                sb.append(strs.get(i).charAt(j));
            }
        }
        return sb.toString(); //return String from string builder
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder(); // construct individual string to be stored in List<String>
        List<String> res = new ArrayList<>(); // stores all the reconstructed words

        StringBuilder intVal = new StringBuilder(); // reconstruct the size of word from string 
        //4-neet4-code ex:

        int i = 0; // itterate from 0 to n

        while (i < str.length()) {

            while(str.charAt(i) != '-') { // reconstruct the wordSize
                intVal.append(str.charAt(i));
                i++;
            }
            i++; //pointer would be at '-' so skip it

            int wordSize = Integer.parseInt(intVal.toString()); // parse int from word
            intVal = new StringBuilder(); // reset words size builder 

            

            int k = i + wordSize; // since now we want to itterate over the word size because we know word would be of that size
            // we itterate from i + wordSize since I would rn be at first letter of word we want to build 
            while (i < k) {
                sb.append(str.charAt(i));
                i++;
            }
            res.add(sb.toString()); // add reconstructed word to string
            sb = new StringBuilder(); // reset string builder fielding the word

        }
        return res;
    }
}
