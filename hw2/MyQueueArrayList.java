package hw2;

import java.util.NoSuchElementException;

public class MyQueueArrayList<Item> {

    protected Object[] que = new Object[2];
    protected int size = 0;
    private  StringBuilder sb = new StringBuilder();
    protected int start = 0;
    protected int end = 0;

    public void log(){
        System.out.println("L " + que.length + " Size " + size + " Start " + start + " End " + end);
    }

    protected void resize(int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++){
            temp[i] = que[(start + i) % que.length];
        }
        start = 0;
        end = size;
        que = temp;
    }

    public int getLength() {
        return que.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(Item item){
        if (size == que.length) resize(que.length * 2);
        que[end++] = item;
        end %= que.length;
        size++;
    }

    public Item dequeue(){
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        Item item = (Item) que[start];
        que[start] = null;
        size--;
        start++;
        start %= que.length;
        if (size > 0 && size == que.length / 4) resize(que.length / 4);
        return item;
    }


    public Item peek(){
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        return (Item) que[start];
    }

    @Override
    public String toString() {
        sb.delete(0, sb.length());
        for (int i = 0; i < size; i++) sb.append(que[(start + i) % que.length] + " ");
        return sb.toString();
    }
}
