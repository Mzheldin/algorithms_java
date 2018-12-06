package hw3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item>{

    private class MyLinkedListIterator implements Iterator<Item>{

        private Node current = start;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw  new NoSuchElementException();
            Item item = current.getItem();
            current = current.getNext();
            return item;
        }
    }

    public Iterator<Item> iterator(){
        return new MyLinkedListIterator();
    }

    private class Node{

        private Node next;
        private Node previous;
        private Item item;

        public Node(Node next, Node previous, Item item) {
            this.next = next;
            this.previous = previous;
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

        public Item getItem() {
            return item;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setItem(Item item) {
            this.item = item;
        }
    }

    private StringBuilder sb = new StringBuilder();
    private int size = 0;
    private Node start;
    private Node end;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(Item item){ //вставка в начало
        if (isEmpty()){
            Node current = new Node(null, null, item);
            start = current;
            end = current;
        } else {
            Node current = new Node(start, null, item);
            start.setPrevious(current);
            start = current;
        }
        size++;
    }

    public void addLast(Item item){ //вставка в конец
        if (isEmpty()){
            Node current = new Node(null, null, item);
            start = current;
            end = current;
        } else {
            Node current = new Node(null, end, item);
            end.setNext(current);
            end = current;
        }
        size++;
    }

    public Item removeFirst(){ //удаление с начала
        if (isEmpty()) throw  new NoSuchElementException();
        Item item = start.getItem();
        if (size == 1){
            start = null;
            end = null;
        } else {
            start.getNext().setPrevious(null);
            start = start.getNext();
        }
        size --;
        return  item;
    }

    public Item removeLast(){ //удаление с конца
        if (isEmpty()) throw  new NoSuchElementException();
        Item item = end.getItem();
        if (size == 1){
            start = null;
            end = null;
        } else {
            end.getPrevious().setNext(null);
            end = end.getPrevious();
        }
        size--;
        return item;
    }

    public Item remove(Item item){ //удаление по элементу
        if (isEmpty()) throw  new NoSuchElementException();
        Item temp;
        Node current = start;
        while (!item.equals(current.getItem())){
            if (current == end) throw  new NoSuchElementException();
            current = current.getNext();
        }
        if (current == start) temp = removeFirst();
        else if (current == end) temp = removeLast();
        else {
            temp = current.getItem();
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            current = null;
            size--;
        }
        return temp;
    }

    public boolean contains(Item item){ //проверка наличия элемента
        if (isEmpty()) return false;
        Node current = start;
        while (true){
            if (item.equals(current.getItem())) return true;
            if (current == end) return false;
            current = current.getNext();
        }
    }

    public int getPos(Item item){ //получение номера позиции элемента, отсчет с 1
        if (!contains(item)) throw  new NoSuchElementException();
        int pos = 1;
        Node current = start;
        while (!item.equals(current.getItem())){
            pos++;
            current = current.getNext();
        }
        return pos;
    }

    public void setItem(int pos, Item item){ //замена элемента на позиции, отсчет с 1
        if (pos < size || pos > size || isEmpty() || !contains(item)) throw  new NoSuchElementException();
        search(pos).setItem(item);
    }

    public Item getItem(int pos){ //получение элемента по номеру позиции, отсчет с 1
        if (pos < size || pos > size || isEmpty()) throw  new NoSuchElementException();
        return search(pos).getItem();
    }

    public Item getFirst(){ //получение первого элемента
        if (isEmpty()) throw  new NoSuchElementException();
        return start.getItem();
    }

    public Item getLast(){ //получение последнего элемента
        if (isEmpty()) throw  new NoSuchElementException();
        return end.getItem();
    }

    private Node search(int pos){ //более оптимальный поиск, как предлагали во время вебинара
        if (pos <= size / 2){
            int currentPos = 1;
            Node current = start;
            while (currentPos != pos){
                currentPos++;
                current = current.getNext();
            }
            return current;
        } else {
            int currentPos = size;
            Node current = end;
            while (currentPos != pos){
                currentPos--;
                current = current.getPrevious();
            }
            return current;
        }
    }

    @Override
    public String toString() {  //вывод в строку
        sb.delete(0, sb.length());
        Iterator<Item> iterator = iterator();
        while (iterator.hasNext()) sb.append(iterator.next() + " ");
        return sb.toString();
    }
}
