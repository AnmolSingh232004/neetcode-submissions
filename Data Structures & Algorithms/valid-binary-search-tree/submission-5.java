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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValid(TreeNode root, long max, long min) {
        if (root == null)return true;

        if (root.val >= max || root.val <= min)return false;
        boolean left = isValid(root.left, root.val, min);
        
        boolean right = isValid(root.right, max, root.val);

        

        return (left && right);
    }
    
}

// so a valid bst can be confirmed if 
// each node stays within its limits
// each right nodes must be less than infinity and greater than its parent
// each left node must be greather than -infinity and less than its parent

// in code we can pass 3 values, root, min, max
// we can adjust min and max for each call
// in the left side min would be -infinty and max would be parent
// int the right side max would be infinity and min would be parent
// if any node breaks this we can make our ans false