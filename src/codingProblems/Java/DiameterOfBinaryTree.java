package codingProblems.Java;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        treeRoot.left.left = new TreeNode(4);
        treeRoot.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(treeRoot));
    }

    /**
     * DFS Backtracking
     * TC: O(n)
     * SC: O(h)
     */
    static int maxDiameter = 0; // instantiate global result

    public static int diameterOfBinaryTree(TreeNode root) {

        // recursive function for calculating the height and diameter of each node from the leave of the tree
        diameterNHeightDFS(root);
        return maxDiameter;
    }

    private static int diameterNHeightDFS(TreeNode root) {

        if (root == null) { // base case, root have no children, return height of 0
            return 0;
        }

        int leftHeight = diameterNHeightDFS(root.left);
        int rightHeight = diameterNHeightDFS(root.right);

        int currentDiameter = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        return 1 + Math.max(leftHeight, rightHeight); // return max height btw left and right node +1 (counting the current node)
    }

    /**
     * Brute Force - DFS using Stack
     * TC: O(n^2), n is number of nodes in binary tree
     * SC: O(h), h is height of the tree
     */
//    public static int diameterOfBinaryTree(TreeNode root) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        int maxDiameter = 0;
//        Stack<Pair<TreeNode, Integer>> nodeHeightStack = new Stack<>();
//        nodeHeightStack.push(new Pair<>(root, 0));
//
//        while (!nodeHeightStack.isEmpty()) {
//            Pair<TreeNode, Integer> currentPair = nodeHeightStack.pop();
//            TreeNode currentNode = currentPair.getKey();
//            int currentHeight = currentPair.getValue();
//
//            int leftHeight = height(currentNode.left);
//            int rightHeight = height(currentNode.right);
//
//            maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
//
//            if (currentNode.left != null) {
//                nodeHeightStack.push(new Pair<>(currentNode.left, currentHeight + 1));
//            }
//            if (currentNode.right != null) {
//                nodeHeightStack.push(new Pair<>(currentNode.right, currentHeight + 1));
//            }
//        }
//
//        return maxDiameter;
//    }
//
//    private static int height(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        return 1 + Math.max(height(node.left), height(node.right));
//    }

    /**
     * Brute Force - DFS using Recursion
     * TC: O(n^2), n is number of nodes in binary tree
     * SC: O(h), h is height of the tree
     */
//    public static int diameterOfBinaryTree(TreeNode root) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        int leftHeight = height(root.left);
//        int rightHeight = height(root.right);
//        int diameterThroughRoot = leftHeight + rightHeight;
//
//        int leftDiameter = diameterOfBinaryTree(root.left);
//        int rightDiameter = diameterOfBinaryTree(root.right);
//
//        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
//    }
//
//    private static int height(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        return 1 + Math.max(height(node.left), height(node.right));
//    }

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
