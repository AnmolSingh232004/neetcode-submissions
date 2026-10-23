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
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSide(root, 1);
        return res;
    }

    public void rightSide(TreeNode root, int lvl) { // lvl = 1 initally, res size = 0 initially
        if (root == null)return;

        if (lvl > res.size())res.add(root.val);
            
        rightSide(root.right, lvl+1);
        rightSide(root.left, lvl+1);
            


    }
}

// we just need to add one node for each depth techincally
// if we can just add the right most node first, then the left node at every level using dfs we can get answer
// we can use length of list as a measurent of which level has an answer already
// we need to pass lvl in for each recursive call to maintain its independence from previous traversal on right sides