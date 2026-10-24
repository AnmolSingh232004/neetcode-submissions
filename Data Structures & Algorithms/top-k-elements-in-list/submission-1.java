class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];

        for (int i=0; i<nums.length; i++) {
            freq[nums[i] + 1000]++; 
        }

        int[] res = new int[k];
        // first value stores max and second value stores its index
        // the value itself for res would be fres[i] + 1, since 2 value wise maps to 3 freq wise

        for (int j=0; j<k; j++) {
            int maxFreq = 0;
            int maxIndex = 0;
        for (int i=0; i<=2000; i++) {

            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxIndex = i;
            }

            if (i == 2000 && j < k) {
                res[j] = maxIndex - 1000;
                freq[maxIndex] = 0;
            }
            if (j >= k)return res;
        }
        }
        return res;
    }
}

// we can make an int[] of size 1000 holding frequency of nums[i] since nums[i] <= 1000
// we populate that freq array with frequencies
// after that we can itterate over the freq array k times and determine highest frequency k times using greedy / Math.max
// Since nums[i] is from -1000 to +1000 we need a +1000 offset