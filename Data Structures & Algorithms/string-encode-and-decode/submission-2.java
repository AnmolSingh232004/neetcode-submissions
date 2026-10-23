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

            while(str.charAt(i) != '-') {
                intVal.append(str.charAt(i));
                i++;
            }
           

            int wordSize = Integer.parseInt(intVal.toString());
            intVal = new StringBuilder();

            i++;

            int k = i + wordSize;
            while (i < k) {
                sb.append(str.charAt(i));
                i++;
            }
            res.add(sb.toString());
            sb = new StringBuilder();

        }
        return res;
    }
}
