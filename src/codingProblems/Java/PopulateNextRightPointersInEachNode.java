package codingProblems.Java;

public class PopulateNextRightPointersInEachNode {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PopulateNextRightPointersInEachNode solution = new PopulateNextRightPointersInEachNode();
        Node res = solution.connect(root);

        Node node = res;
        while (node != null) {
            Node current = node;

            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }

            node = node.left; // move to the next lvl
        }
    }

    /**
     * Iterative using previous node .next
     * TC: O(n)
     * SC: O(1)
     */
    public static Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node startNode = root;
        while (startNode != null) {

            Node current = startNode;
            while (current != null) {

                if (current.left != null) {
                    current.left.next = current.right;
                }
                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next; // next node in the same lvl
            }

            startNode = startNode.left; // start new lvl
        }
        return root;
    }

    /**
     * DFS - recursion
     * TC: O(n)
     * SC: O(h), h is the height of the tree for recursion
     * - O(log n) best case in balanced binary tree
     * - O(n) worst case in skewed tree
     */
//    public static Node connect(Node root) {
//
//        if (root == null) {
//            return null;
//        }
//
//        if (root.left != null) {
//            root.left.next = root.right;
//        }
//        if (root.right != null && root.next != null) {
//            root.right.next = root.next.left;
//        }
//
//        connect(root.left);
//        connect(root.right);
//
//        return root;
//    }

    /**
     * DFS - new recursion method
     * TC: O(n)
     * SC: O(h), h is height of the tree due to recursion stack
     */
//    public static Node connect(Node root) {
//
//        if (root == null) {
//            return null;
//        }
//
//        connectNode(root.left, root.right);
//        return root;
//    }
//
//    private static void connectNode(Node leftNode, Node rightNode) {
//
//        if (leftNode == null || rightNode == null) {
//            return;
//        }
//
//        leftNode.next = rightNode;
//
//        // connect children of same subtree
//        connectNode(leftNode.left, leftNode.right);
//        connectNode(rightNode.left, rightNode.right);
//
//        connectNode(leftNode.right, rightNode.left); // connect across subtree
//    }

    /**
     * BFS
     * TC: O(n)
     * SC: O(m), m is the max number of nodes at any lvl
     */
//    public static Node connect(Node root) {
//
//        if (root == null) {
//            return null;
//        }
//
//        Queue<Node> toBeSeenQueue = new LinkedList<>();
//        toBeSeenQueue.offer(root);
//
//        while (!toBeSeenQueue.isEmpty()) {
//            int levelSize = toBeSeenQueue.size(); // keep track of ele in that lvl
//            Node prev = null;
//
//            for (int i = 0; i < levelSize; i++) {
//                Node current = toBeSeenQueue.poll();
//
//                if (prev != null) {
//                    prev.next = current;
//                }
//
//                prev = current;
//
//                if (current.left != null) {
//                    toBeSeenQueue.offer(current.left);
//                }
//                if (current.right != null) {
//                    toBeSeenQueue.offer(current.right);
//                }
//            }
//        }
//
//        return root;
//    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
