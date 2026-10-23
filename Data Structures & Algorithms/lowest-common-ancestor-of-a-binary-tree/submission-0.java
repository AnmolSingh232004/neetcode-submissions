/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p)return root;
        if (root == null)return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right == null) {
            return left;
        } else if (right != null && left == null) {
            return right;
        } else if (left != null && right != null) {
            return root;
        } else {
            return null;
        }

    }
}

// we go in one direction if no p or q is found we return null from that side
// if p or q is found on either side we return p and q from each side
// if p or q is found on one side then we return the one we found first
// if root recives two non nulls it is answer