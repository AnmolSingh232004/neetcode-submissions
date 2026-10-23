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
        if (root == null)return null;
        if (p == null || q == null)return null;
        if (root == p || root == q)return root;

        if (Math.max(p.val, q.val) < root.val)
        return lowestCommonAncestor(root.left, p, q);
        else if (Math.min(p.val, q.val) > root.val)
        return lowestCommonAncestor(root.right, p, q);
        else
        return root;

    }
}

// basically we just try to find either p or q on either side

// we find p or q at any time we return them
// if p or q == root itself at any point we return that

// if the biggest value of both is on left we go left
// if the smalllest value of bot is on right we go right