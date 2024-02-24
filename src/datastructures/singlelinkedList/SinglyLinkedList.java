package datastructures.singlelinkedList;

public class SinglyLinkedList<T> {

    private final class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean search(T value) {
        Node current = head;
        boolean found = false;
        while (current != null && !found) {
            if (current.data == value) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    public void remove(T value) {
        if (head == null) {
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
