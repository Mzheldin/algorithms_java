package hw2;

import java.util.NoSuchElementException;

public class MyStackArrayListD<Item> {

    private Object[] stack = new Object[1];
    private int size = 0;
    private  StringBuilder sb = new StringBuilder();


    private void resize(int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) temp[i] = stack[i];
        stack = temp;
    }

    public int getSize() {
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public Item peek(){
        if (!isEmpty()) return (Item) stack[size - 1];
        else {
            throw  new NoSuchElementException();
        }
    }

    public void push(Item item){
        if (size == stack.length) resize(stack.length * 2);
        stack[size++] = item;
    }

    public Item pop(){
        if (!isEmpty()){
            Item item = (Item) stack[size - 1];
            stack[size - 1] = null;
            size--;
            if (size == stack.length / 3) resize(stack.length / 3);
            return item;
        } else {
            throw  new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        sb.delete(0, sb.length());
        for (int i = 0; i < size; i++) sb.append(stack[i] + " ");
        return sb.toString();
    }
}
