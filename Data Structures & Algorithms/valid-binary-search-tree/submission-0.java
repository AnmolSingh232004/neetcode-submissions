/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    boolean res = true;

    public boolean checkIncreasing(List<Integer> list) {
        int var = list.get(0);
        for (int i=1; i<list.size(); i++) {
            if (list.get(i) <= list.get(i-1))return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return checkIncreasing(list);
    }

    public void inOrder(TreeNode root) {
        if (root == null)return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

}