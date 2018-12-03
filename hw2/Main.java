package hw2;

public class Main {

    public static void main(String[] args) {
        System.out.println("Стек статического размера");
        MyStackArrayListS<Integer> staticStack = new MyStackArrayListS<>(5);
        for (int i = 0; i < staticStack.getLength(); i++) staticStack.push(i);
        System.out.println(staticStack.toString());
        System.out.println(staticStack.peek());
        staticStack.pop();
        staticStack.pop();
        System.out.println(staticStack.peek());
        staticStack.push(10);
        System.out.println(staticStack.peek());

        System.out.println("\nСтек динамического размера");
        MyStackArrayListD<Integer> dinamicStack = new MyStackArrayListD<>();
        for (int i = 0; i < 5; i++) dinamicStack.push(i);
        System.out.println(dinamicStack.toString());
        System.out.println(dinamicStack.peek());
        dinamicStack.pop();
        dinamicStack.pop();
        System.out.println(dinamicStack.peek());
        dinamicStack.push(10);
        System.out.println(dinamicStack.peek());

        System.out.println("\nОчередь динамического размера");
        MyQueueArrayList<Integer> que = new MyQueueArrayList<>();
        for (int i = 0; i < 5; i++) que.enqueue(i);
        System.out.println(que.toString());
        System.out.println(que.peek());
        que.dequeue();
        que.dequeue();
        System.out.println(que.peek());
        System.out.println(que.toString());

        System.out.println("\nПереворачивание строки");
        StringReverse stringReverse = new StringReverse();
        System.out.println(stringReverse.reverse("Перевернутый текст"));

        System.out.println("\nДек");
        MyDeckArray deck = new MyDeckArray();
        for (int i = 0; i < 5; i++) deck.insertRight(i);
        System.out.println(deck.toString());
        for (int i = 0; i < 5; i++) deck.insertLeft(i);
        System.out.println(deck.toString());
        deck.removeLeft();
        deck.removeRight();
        deck.removeRight();
        System.out.println(deck.peekRight());
        deck.insertLeft(10);
        System.out.println(deck.peekLeft());
        System.out.println(deck.toString());
        for (int i = 0; i < 6; i++) deck.removeRight();
        System.out.println(deck.toString());
        deck.log();
    }
}
