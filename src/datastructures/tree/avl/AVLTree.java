package datastructures.tree.avl;

public class AVLTree<T extends Comparable<T>> {
    private final class Node {
        T data;
        Node left;
        Node right;
        int height;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;

    public AVLTree() {
        root = null;
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    public void delete(T data) {
        root = delete(data, root);
    }

    private Node insert(T data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
        } else {
            return node;
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && data.compareTo(node.left.data) < 0) { // Left Left დარღვევა
            return rightRotate(node);
        }
        if (balance < -1 && data.compareTo(node.right.data) > 0) { // Right Right დარღვევა
            return leftRotate(node);
        }
        if (balance > 1 && data.compareTo(node.left.data) > 0) { // Left Right დარღვევა
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data.compareTo(node.right.data) < 0) { // Right Left დარღვევა
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node node) {
        Node leftChild = node.left;
        Node rightGrandchild = leftChild.right;

        leftChild.right = node;
        node.left = rightGrandchild;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        leftChild.height = Math.max(getHeight(leftChild.left), getHeight(leftChild.right)) + 1;

        return leftChild;
    }

    private Node leftRotate(Node node) {
        Node rightChild = node.right;
        Node leftGrandchild = rightChild.left;

        rightChild.left = node;
        node.right = leftGrandchild;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        rightChild.height = Math.max(getHeight(rightChild.left), getHeight(rightChild.right)) + 1;

        return rightChild;
    }

    private Node delete(T data, Node node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = delete(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(data, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = findMin(node.right);
                node.data = successor.data;
                node.right = delete(successor.data, node.right);
            }
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalance(node);

        return balanceTree(node);
    }

    private Node balanceTree(Node node) {
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) { // Left Left დარღვევა
            return rightRotate(node);
        } else if (balance > 1 && getBalance(node.left) < 0) { // Left Right დარღვევა
            node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if (balance < -1 && getBalance(node.right) <= 0) { // Right Right დარღვევა
            return leftRotate(node);
        } else if (balance < -1 && getBalance(node.right) > 0) { // Right Left დარღვევა
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
