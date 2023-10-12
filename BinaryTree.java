package DataStructuresAndAlgorithms;

/**
 * This class implements a binary search tree data structure.
 * It provides basic operations to insert and search for values,
 * as well as various tree traversal methods.
 */
public class BinaryTree {

    /**
     * This class represents a node in the binary tree.
     */
    private class Node {
        private int value; // The value stored in this node
        private Node leftChild; // The left child of this node
        private Node rightChild; // The right child of this node

        /**
         * Constructs a new Node with the given value.
         *
         * @param value the value to store in this node
         */
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root; // The root of the tree

    /**
     * Inserts a new value into the binary tree.
     *
     * @param value the value to insert
     */
    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    /**
     * Searches for a value in the binary tree.
     *
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Traverses the tree in pre-order (root, left, right) and prints the values.
     */
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        // root, left, right
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    /**
     * Traverses the tree in in-order (left, root, right) and prints the values.
     */
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        // left, root, right
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    /**
     * Traverses the tree in post-order (left, right, root) and prints the values.
     */
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        // left, right, root
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    /**
     * Computes the height of the tree.
     *
     * @return the height of the tree
     */
    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    /**
     * Computes the minimum value in the binary tree.
     * Assumes Binary Tree, not Binary Search Tree - O(n).
     *
     * @return the minimum value in the tree
     */
    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    /**
     * Searches for the minimum value in the binary search tree.
     * Done in logarithmic time O(log(n)).
     *
     * @return the minimum value in the binary search tree
     */
    public int searchTreeMin() {
        if (root == null)
            throw new IllegalStateException("Tree can't be empty.");

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    /**
     * Checks if the specified node is a leaf node.
     *
     * @param node the node to check
     * @return true if the node is a leaf node, false otherwise
     */
    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    /**
     * Main method to test the BinaryTree implementation with sample operations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println("Height: " + tree.height());
        System.out.println("Min for Binary Tree: " + tree.min());
        System.out.println("Min for Binary Search Tree: " + tree.searchTreeMin());

        System.out.println("Value 4 Exists: " + tree.find(4));
        System.out.println("Value 3 Exists: " + tree.find(3));

        System.out.println("Pre-Order Traversal:");
        tree.traversePreOrder();
        System.out.println("In-Order Traversal:");
        tree.traverseInOrder();
        System.out.println("Post-Order Traversal:");
        tree.traversePostOrder();
    }
}
