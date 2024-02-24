package datastructures.tree.bst;

public class BinarySearchTree<T extends Comparable<T>> {
    private final class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void insert(T value) {
        root = insert(value, root);
    }

    public boolean search(T value) {
        return search(value, root);
    }

    public void delete(T data) {
        root = delete(data, root);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }
    public void preorderTraversal() {
        preorderTraversal(root);
    }
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private Node insert(T value, Node node) {
        if (node == null) {
            return new Node(value);
        }
        if (value.compareTo(node.data) < 0) {
            node.left = insert(value, node.left);
        } else {
            node.right = insert(value, node.right);
        }
        return node;
    }

    private boolean search(T value, Node node) {
        boolean found = false;
        while (node != null && !found) {
            if (node.data == value) {
                found = true;
            } else if (value.compareTo(node.data) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return found;
    }

    private void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    private void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    private void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
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
