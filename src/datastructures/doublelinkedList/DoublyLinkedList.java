package datastructures.doublelinkedList;

import java.util.NoSuchElementException;

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
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T value) {
        Node node = new Node(value);

        if (head != null) {
            head.prev = node;
            node.next = head;

        }
        head = node;
        size++;
    }

    public void addLast(T value) {
        Node node = new Node(value);

        if (isEmpty()) {
            addFirst(value);
        } else {
            Node last = getNode(size - 1);
            last.next = node;
            node.prev = last;
            size++;
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size){
            throw  new IndexOutOfBoundsException("Index out of the bound");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void add(T value, int index) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        Node node = new Node(value);
        Node before = getNode(index - 1);

        node.next = before.next;
        node.next.prev = node;
        node.prev = before;
        before.next = node;
        size++;
    }

    public boolean search(T value) {
        boolean found = false;
        Node current = head;
        while (!found && current != null) {
            if (current.data == value) {
                found = true;
            }
            else {
                current = current.next;
            }
        }
        return found;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T value =  head.data;

        if (size == 1) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (size == 1) {
            return removeFirst();
        }

        Node node = getNode(size - 2);
        T value =  node.next.data;
        node.next = null;
        size--;
        return  value ;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node before = getNode(index - 1);
        T value =  before.next.data;
        before.next = before.next.next;

        if (before.next != null) {
            before.next.prev = before;
        }

        size--;
        return value;
    }

    public void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
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
