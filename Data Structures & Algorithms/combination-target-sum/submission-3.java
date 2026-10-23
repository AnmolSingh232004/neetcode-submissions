class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        dfs(nums, 0, target, new ArrayList<Integer>(), new HashSet<List<Integer>>());

        return res;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> comb, Set<List<Integer>> set) {
        if (target == 0) {
            List<Integer> sortedComb = new ArrayList<>(comb);
            Collections.sort(sortedComb);
            if (!set.contains(sortedComb)) {
            res.add(new ArrayList<>(sortedComb) );
            set.add(new ArrayList<>(sortedComb) );
            }
            return;
        }

        if (i == nums.length || target < 0)return;

        comb.add(nums[i]);
        dfs(nums, i, target - nums[i], comb, set);
        comb.remove(comb.size() - 1);

        dfs(nums, i+1, target, comb, set);

    }
}
