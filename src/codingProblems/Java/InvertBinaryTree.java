package codingProblems.Java;

public class InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertTree(root);

        root.printPreOrder(root);
    }

    /**
     * DFS Recursive
     * TC: O(n)
     * SC: O(log n), in balanced binary tree from log(n)(based 2),
     * - in unbalanced binary tree O(n), where height of tree can be equal to number of nodes
     * -- O(h) from invertTree function
     */
    public static TreeNode invertTree(TreeNode root) {

        swapNode(root);
        return root;
    }

    private static TreeNode swapNode(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode left = swapNode(node.left);
        TreeNode right = swapNode(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static void printPreOrder(TreeNode root) {

            if (root == null) {
                return;
            }

            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }
}
