class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])continue;
            int l = i+1;
            int r = nums.length-1;

            while (l < r) {
                int tSum = nums[i] + nums[l] + nums[r];
                if (tSum < 0) {  //since sum is smaller we need a bigger value so l++
                    l++;
                }
                else if(tSum > 0) { //we need a smaller number
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l-1])l++;
                }
                }
            }
                    return res;
        }
    }



// sorted
// [-4,-1,-1,0,1,2]