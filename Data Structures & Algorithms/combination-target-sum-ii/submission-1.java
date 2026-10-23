class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int target, int i, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i == nums.length || target < 0)return;;
        

        list.add(nums[i]);
        dfs(nums, target - nums[i], i+1, list);
        list.remove(list.size() - 1);

        while (i+1 != nums.length && nums[i] == nums[i+1])i++;
        dfs(nums, target, i+1, list);
    }
}

// [1,2,2,4,5,6,9] || target = 8