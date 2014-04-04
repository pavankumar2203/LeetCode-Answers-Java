/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/**
 * T(n) = 2T(n/2) + O(n)
 * O(nlg(n)) O(n)
 */
 
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if(inorder.length == 1) return root;
        //find root.val in inorder
        int i = 0;
        while(i < inorder.length) {
            if(inorder[i] == root.val) {
                break;
            }
            i++;
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
        return root;
    }
}
