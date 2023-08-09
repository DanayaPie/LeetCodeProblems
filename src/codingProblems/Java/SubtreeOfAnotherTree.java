package codingProblems.Java;

import javax.swing.tree.TreeNode;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subRoot));
    }

    /**
     * Backtracking - DFS of main tree
     * TC: O(n * m) n is number of nodes in main tree and m is number of nodes in subtree
     * SC: O(h)
     * - O(n) worst case, height of main tree equal to number of nodes
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        // if nodes match, check its children
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


