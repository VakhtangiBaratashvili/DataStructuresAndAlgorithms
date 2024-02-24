package datastructures.list;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println(list.getSize());
        list.remove(4);
        System.out.println(list);
    }
}
