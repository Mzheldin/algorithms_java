package hw3;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 5; i++) list.addFirst(i);
        System.out.println(list.getSize());
        System.out.println(list.toString());
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list.toString());
        list.addLast(10);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
    }
}
