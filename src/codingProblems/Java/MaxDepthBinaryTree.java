package codingProblems.Java;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {

        TreeNode currentNode = root;

        if (currentNode == null) {
            return 0;
        }

        int left = maxDepth(currentNode.left);
        int right = maxDepth(currentNode.right);

        return Math.max(left, right) + 1;
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
    }
}
