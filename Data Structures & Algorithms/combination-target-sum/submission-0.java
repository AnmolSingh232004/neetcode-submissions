class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, target, list);
        return res;
    }

    public void dfs(int[] candidates, int i, int target, List<Integer> combination) {
        if (i == candidates.length || target < 0)return;

        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        combination.add(candidates[i]);
        dfs(candidates, i, target - candidates[i], combination);
        // keeping i the same allows reuse of the current element; target decreases because we used it

        combination.remove(combination.size() - 1);
        dfs(candidates, i+1, target, combination);
        // this call says skip current element and therefore dont update target since we skip it

    }
}
