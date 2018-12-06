package hw3;

public class MyLinkedListStack<Item> {
    MyLinkedList<Item> list = new MyLinkedList<>();

    public void push(Item item){
        list.addLast(item);
    }

    public Item pop(){
        return list.removeLast();
    }

    public Item peek(){
        return list.getLast();
    }

    public int size(){
        return list.getSize();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
