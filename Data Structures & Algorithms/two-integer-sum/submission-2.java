class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }


        for (int i=0; i<nums.length; i++) {
            if ( map.containsKey(target - nums[i]) && i != map.get(target - nums[i]))
            return new int[]{i, map.get(target - nums[i])};
        }
        return new int[]{0,0};
    }
}


// target = nums[i] + nums[j]
// we can set either i or j to one value
// we can find lets say j using nums[j] = target - nums[i]