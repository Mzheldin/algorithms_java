package hw5;

public class Main {
    public static void main(String[] args) {
//        BST<Character, Integer> assArr = new BST<>();
//        assArr.put('S', 123);
//        assArr.put('E', 345);
//        System.out.println(assArr.isBalanced());
//        assArr.put('A', 123);
//        System.out.println(assArr.isBalanced());
//        assArr.put('C', 987);
//        System.out.println(assArr.isBalanced());
//        assArr.put('R', 911);
//        System.out.println(assArr.isBalanced());
//        assArr.put('H', 112);
//        assArr.put('M', 012);
//        assArr.put('X', 003);
//        System.out.println(assArr.isBalanced());
//        assArr.delete('M');
//        assArr.delete('H');
//        System.out.println(assArr.isBalanced());
//        assArr.delete('C');
//        System.out.println(assArr.isBalanced());
//        System.out.println(assArr.getHeight());
//        assArr.delete('A');
//        assArr.delete('R');
//        System.out.println(assArr.getHeight());
//        System.out.println();
//        System.out.println(assArr.size());
//        System.out.println(assArr.isBalanced());

        TreeCreator creator = new TreeCreator();
        creator.balancedTree(creator.create(20, 6));

        BST<Integer, Integer> test = creator.createOne(6);
        System.out.println(test.size());
        System.out.println(test.getHeight());
    }
}
