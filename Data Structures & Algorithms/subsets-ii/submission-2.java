class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        dfs(nums, 0, new ArrayList<>());

        return res;
        
    }

    public void dfs(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i+1, subset);    
        subset.remove(subset.size() - 1);

        
        while (i < nums.length-1 && nums[i+1] == nums[i])i++;
        dfs(nums, i+1, subset);
    }
}
