package hw3;

public class MyLinkedListQue<Item> {
    MyLinkedList<Item> list = new MyLinkedList<>();

    public void enqueue(Item item){
        list.addLast(item);
    }

    public Item dequeue(){
        return list.removeFirst();
    }

    public Item peek(){
        return list.getFirst();
    }

    public int size(){
        return list.getSize();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
