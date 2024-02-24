package datastructures.doublelinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        System.out.println(list.isEmpty());
        System.out.println(list);
        for (int i = 1; i <= 5 ; i++) {
            list.add(i);
        }
        System.out.println(list.isEmpty());
        System.out.println(list);
    }
}
