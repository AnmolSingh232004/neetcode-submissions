class Solution {
    Set<List<Integer>> set = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(candidates, 0, target, list);
        return res;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> list) {

        if (target == 0) {
            List<Integer> localList = new ArrayList<>(list);
            Collections.sort(localList);
            if (set.contains(localList)) {
                return;
            }
            else {
                set.add(localList);
                res.add(localList);
                return;
            }
        }

        if (i == nums.length || target < 0)return;

        
        list.add(nums[i]);
        dfs(nums, i+1, target - nums[i], list);
        list.remove(list.size()- 1);
        
        dfs(nums, i+1, target, list);
    }
}

// we can find all combinations that sum up to target 
// and add them to a hashset if that combination already exists dont add it to list or else do it