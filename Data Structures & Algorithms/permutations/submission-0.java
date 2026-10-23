class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> perm = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, perm, used);

        return res;
    }

    public void dfs(int[] nums, List<Integer> perm, boolean[] used) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if ( !used[i] ) {
                used[i] = true;
                perm.add(nums[i]);
                dfs(nums, perm, used);

                perm.remove(perm.size() - 1);
                dfs(nums, perm, used);
                used[i] = false;
            }
        }
    }
}
