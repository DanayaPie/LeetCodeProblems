package codingProblems.Java;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {

        MaxDepthBinaryTreeNode root = new MaxDepthBinaryTreeNode(3);
        root.left = new MaxDepthBinaryTreeNode(9);
        root.right = new MaxDepthBinaryTreeNode(20);
        root.right.left = new MaxDepthBinaryTreeNode(15);
        root.right.right = new MaxDepthBinaryTreeNode(7);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(MaxDepthBinaryTreeNode root) {

        MaxDepthBinaryTreeNode currentNode = root;

        if (currentNode == null) {
            return 0;
        }

        int left = maxDepth(currentNode.left);
        int right = maxDepth(currentNode.right);

        return Math.max(left, right) + 1;
    }
}

class MaxDepthBinaryTreeNode {
    int val;
    MaxDepthBinaryTreeNode left;
    MaxDepthBinaryTreeNode right;

    MaxDepthBinaryTreeNode() {
    }

    MaxDepthBinaryTreeNode(int val) {
        this.val = val;
    }

    MaxDepthBinaryTreeNode(int val, MaxDepthBinaryTreeNode left, MaxDepthBinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
