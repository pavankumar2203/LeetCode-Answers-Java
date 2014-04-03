/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

/**
 * T(n) = T(0)*T(n-1) + T(1)*T(n-2) + T(2)*T(n-3) + ... + T(n - 2)*T(1) + T(n - 1)*T(0)
 * O(n!)
 * we can also save the immediate result and optimize
 */

public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        int[] a = new int[n];
        for(int i = 1; i <= n; i++) {
            a[i - 1] = i;
        }
        return generateTrees(a);
    }
    private ArrayList<TreeNode> generateTrees(int[] arr) {
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        if(arr.length == 0) {
            nodes.add(null);
            return nodes;
        }
        if(arr.length == 1) {
            nodes.add(new TreeNode(arr[0]));
            return nodes;
        }
        for(int i = 0; i < arr.length; i++) {
            for(TreeNode left : generateTrees(Arrays.copyOfRange(arr, 0, i))) {
                for(TreeNode right : generateTrees(Arrays.copyOfRange(arr, i + 1, arr.length))) {
                    TreeNode root = new TreeNode(arr[i]);
                    root.left = left;
                    root.right = right;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }
}
