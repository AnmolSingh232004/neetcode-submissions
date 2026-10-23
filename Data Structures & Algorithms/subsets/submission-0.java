class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(0, nums, subset, res);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {

        // Base case: all elements have been processed
        // Current subset represents one valid subset
        if (i == nums.length) {
            res.add(new ArrayList<>(subset)); // copy because subset is mutable
            return;
        }

        // Choice 1: include nums[i]
        subset.add(nums[i]);
        dfs(i + 1, nums, subset, res);

        // Backtrack: undo the inclusion of nums[i]
        // This restores subset to its previous state
        subset.remove(subset.size() - 1);

        // Choice 2: exclude nums[i]
        dfs(i + 1, nums, subset, res);
    }
}
