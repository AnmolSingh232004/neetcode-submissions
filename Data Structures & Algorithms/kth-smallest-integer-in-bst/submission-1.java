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
    int count = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        findK(root, k);
        return res;
    }

    public void findK(TreeNode root, int k) {
        if (root == null)return;
        if (count > k)return;

        findK(root.left, k);
        count++;
        if (k == count)res = root.val;
        findK(root.right, k);
    }
}
