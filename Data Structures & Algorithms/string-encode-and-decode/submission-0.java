class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append('-');
            for (int j=0; j<strs.get(i).length(); j++) {
                sb.append(strs.get(i).charAt(j));
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        StringBuilder intVal = new StringBuilder();
        //4-neet4-code

        int i = 0;

        while (i < str.length()) {

            while(i < str.length() && str.charAt(i) != '-') {
                intVal.append(str.charAt(i));
                i++;
            }
            if (intVal.length() == 0)break;

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
