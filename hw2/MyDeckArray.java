package hw2;

import java.util.NoSuchElementException;

public class MyDeckArray<Item> extends MyQueueArrayList {

    public void insertRight(Item item){
        super.enqueue(item);
    }

    public Item removeLeft(){
        return (Item) super.dequeue();
    }

    public void insertLeft(Item item){
        if (size == que.length) resize(que.length * 2);
        if (start == 0) start = que.length - 1;
        else start--;
        que[start] = item;
        start %= que.length;
        size++;
    }

    public Item removeRight(){
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        if (end == 0) end = que.length - 1;
        else end--;
        Item item = (Item) que[end];
        que[end] = null;
        size--;
        end %= que.length;
        if (size > 0 && size == que.length / 4) resize(que.length / 4);
        return item;
    }

    public Item peekRight(){
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        return (Item) que[end - 1];
    }

    public Item peekLeft(){
        return (Item) super.peek();
    }

}
