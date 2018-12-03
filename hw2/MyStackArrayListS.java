package hw2;

import java.util.NoSuchElementException;

public class MyStackArrayListS<Item> {

    private Object[] stack;
    private int size = 0;
    private  StringBuilder sb = new StringBuilder();


    public MyStackArrayListS(int maxLength){
        stack = new Object[maxLength];
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return stack.length;
    }

    public boolean isFull(){
        return size == stack.length;
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
        if (!isFull()) stack[size++] = item;
        else System.out.println("Stack is full!");
    }

    public Item pop(){
        if (!isEmpty()){
            Item item = (Item) stack[size - 1];
            stack[size - 1] = null;
            size--;
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
