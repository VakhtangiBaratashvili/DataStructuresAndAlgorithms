package datastructures.doublelinkedList;

public class DoublyLinkedList<T> {

    private final class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public boolean search(T value) {
        boolean found = false;
        Node current = head;
        while (!found && current != null) {
        }

        return found;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" <-> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
