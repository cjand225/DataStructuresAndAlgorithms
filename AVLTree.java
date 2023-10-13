package DataStructuresAndAlgorithms;

/**
 * This class implements an AVL Tree.
 * AVL Tree is a self-balancing Binary Search Tree (BST) 
 * where the difference between heights of left and right subtrees 
 * cannot be more than one for all nodes.
 */
public class AVLTree {

    /**
     * Inner class to represent nodes in the AVL Tree.
     */
    private class AVLNode {
        private int value;  // Value stored in the node
        private int height;  // Height of the node from the leaf
        private AVLNode leftChild;  // Left child of the node
        private AVLNode rightChild;  // Right child of the node

        /**
         * Constructs a new node with the given value.
         *
         * @param value the value to store in this node
         */
        public AVLNode(int value) {
            this.value = value;
            this.height = 0;
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    private AVLNode root;  // Root of the AVL Tree

    /**
     * Inserts a new value into the AVL Tree.
     *
     * @param value the value to insert
     */
    public void insert(int value) {
        root = insert(root, value);
    }

    /**
     * Recursive helper method to insert a new value into the AVL Tree.
     *
     * @param root the root of the tree/sub-tree
     * @param value the value to insert
     * @return the root of the tree/sub-tree
     */
    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        setHeight(root);

        return balance(root);
    }

    /**
     * Balances the AVL Tree from the given root node.
     *
     * @param root the root of the tree/sub-tree
     * @return the balanced root of the tree/sub-tree
     */
    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);

            return rotateRight(root);

        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);

            return rotateLeft(root);
        }

        return root;
    }

    /**
     * Rotates the given root node to the left.
     *
     * @param root the root of the tree/sub-tree
     * @return the new root after rotation
     */
    private AVLNode rotateLeft(AVLNode root) {

        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    /**
     * Rotates the given root node to the right.
     *
     * @param root the root of the tree/sub-tree
     * @return the new root after rotation
     */
    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    /**
     * Sets the height of the given node based on its children's heights.
     *
     * @param node the node whose height is to be set
     */
    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    /**
     * Returns the height of the given node.
     *
     * @param node the node whose height is to be returned
     * @return the height of the node, or -1 if the node is null
     */
    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    /**
     * Returns the balance factor of the given node.
     *
     * @param node the node whose balance factor is to be returned
     * @return the balance factor of the node, or 0 if the node is null
     */
    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    /**
     * Checks if the given node is left heavy.
     *
     * @param node the node to check
     * @return true if the node is left heavy, false otherwise
     */
    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    /**
     * Checks if the given node is right heavy.
     *
     * @param node the node to check
     * @return true if the node is right heavy, false otherwise
     */
    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    /**
     * Main method to test the AVL Tree implementation.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        var tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
    }
}
