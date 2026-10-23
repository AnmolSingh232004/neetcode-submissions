class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void dfs(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                list.add(nums[i]);
                dfs(nums, list, used);
                list.remove(list.size() - 1);

                used[i] = false;
            }
        }
    } 
}
