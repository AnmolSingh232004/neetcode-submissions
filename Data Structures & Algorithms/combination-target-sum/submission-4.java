class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        dfs(nums, 0, target, new ArrayList<Integer>());

        return res;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> comb) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if (target < 0 || i == nums.length)return;

        comb.add(nums[i]);
        dfs(nums, i, target - nums[i], comb);
        comb.remove(comb.size() - 1);

        dfs(nums, i+1, target, comb);
    }
}
