package hw1;

public class MyArrayList<Item extends Comparable<Item>> {
    private int size = 0;
    private Object[] list = new Object[1];

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }

    public int size() {
        return size;
    }

    public void insert(Item item) {
        if (size == list.length) {
            resize(2 * list.length);
        }
        list[size++] = item;
    }

    public boolean delete(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        list[size - 1] = null;
        size--;

        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }

        return true;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        list[index] = item;
    }

    public boolean find(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + list[i] + ", ";
        }
        return s;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item) list[j], (Item) list[min])) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    public void insertionSort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) list[j], (Item) list[j - 1])) {
                    exch(j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 1; i--){
            for (int j = 0; j < i; j++) if (less((Item) list[j + 1], (Item) list [j])) exch(j, j + 1);
        }
    }

    private boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    private void exch(int i, int j) {
        Item temp = (Item) list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public void clear(){
        size = 0;
        resize(0);
    }

    public MyArrayList copy(){
        MyArrayList<Item> copyList = new MyArrayList<>();
        for (int i = 0; i < size; i++){
            copyList.insert(this.get(i));
        }
        return copyList;
    }
}