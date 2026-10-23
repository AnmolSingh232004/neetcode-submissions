class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> list, int currSum) {
        if (currSum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i == nums.length || currSum > target)return;

        list.add(nums[i]);
        dfs(nums, i, target, list, currSum + nums[i]);
        list.remove(list.size() - 1);

        dfs(nums, i+1, target, list, currSum);
    }
}
