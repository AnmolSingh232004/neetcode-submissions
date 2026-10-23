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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

        while (q.size() != 0) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
        for (int i=0; i<size; i++) {
            TreeNode currNode = q.poll();

            if (currNode != null) {
                level.add(currNode.val);
                q.add(currNode.left);
                q.add(currNode.right);
            }
        }

        if (level.size() > 0)res.add(level);

        }
        return res;
    }
}

//