package hw7;

public class Main {

    public static void main(String[] args) {

        LinearProbingHashTable<Integer, Character> test1 = new LinearProbingHashTable<>();

        System.out.println(test1.getSize());
        test1.put(1, '1');
        System.out.println(test1.toString());
        test1.put(2, '2');
        System.out.println(test1.toString());
        test1.put(3, '3');
        System.out.println(test1.toString());
        System.out.println(test1.getSize());
        test1.put(4, '4');
        test1.put(5, '5');
        System.out.println(test1.toString());
        System.out.println(test1.getSize());
        System.out.println(test1.remove(4));
        System.out.println(test1.toString());
        System.out.println(test1.getSize());


        ChainingHashTable<Integer, Character> test2 = new ChainingHashTable<>();

        System.out.println(test2.getSize());
        test2.put(1, '1');
        System.out.println(test2.toString());
        test2.put(2, '2');
        System.out.println(test2.toString());
        test2.put(3, '3');
        System.out.println(test2.toString());
        System.out.println(test2.getSize());
        test2.put(4, '4');
        test2.put(5, '5');
        System.out.println(test2.toString());
        System.out.println(test2.getSize());
        System.out.println(test2.remove(4));
        System.out.println(test2.toString());
        System.out.println(test2.getSize());

    }

}
