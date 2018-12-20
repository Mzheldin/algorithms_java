package hw7;

import java.util.Arrays;

public class ChainingHashTable<Key, Value> {

    private int size = 0;
    private int M = 3;
    private Object[] keys = new Object[M];
    private StringBuilder sb = new StringBuilder();

    private class Node {

        private Key key;
        private Value value;
        private Node next;
        private Node previous;

        public Node(Key key, Value value, Node next, Node previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key){
        if (key == null) throw new IllegalArgumentException("Ключ не должен быть null");
        Node x = (Node) keys[hash(key)];
        while (x != null){
            if (key.equals(x.key)) return x.value;
            x = x.next;
        }
        return null;
    }

    public void put(Key key, Value value){
        if (key == null) throw new IllegalArgumentException("Ключ не должен быть null");
        if (size == M) resize();
        Node x = (Node) keys[hash(key)];
        if (x == null) {
            keys[hash(key)] = new Node(key, value, null, null);
            size++;
        }
        else {
            while (true){
                if (key.equals(x.key)) {
                    x.value = value;
                    return;
                }
                if (x.next == null) {
                    x.next = new Node(key, value, null, x);
                    size++;
                    return;
                }
                x = x.next;
            }
        }
    }

    public Value remove(Key key){
        if (!contains(key)) throw new IllegalArgumentException("Указанного ключа не существует");
        Node x = (Node) keys[hash(key)];
        Value temp;
        while (x != null){
            if (key.equals(x.key)) {
                temp = x.value;
                if (x.previous == null) {
                    if (x.next == null) keys[hash(key)] = null;
                    else keys[hash(key)] = x.next;
                }
                else {
                    if (x.next == null) x.previous.next = null;
                    else {
                        x.previous.next = x.next;
                        x.next.previous = x.previous;
                    }
                }
                size--;
                return temp;
            }
            x = x.next;
        }
        return  null;
    }

    private void resize(){
        int oldLength = M;
        M = getNextPrimeNumber(M);
        Object[] tempKeys = keys;
        keys = new Object[M];
        size = 0;
        for (int i = 0; i < oldLength; i++) {
            if (tempKeys[i] != null){
                Node x = (Node) tempKeys[i];
                while (x != null){
                    put(x.key, x.value);
                    x = x.next;
                }
            }
        }
    }

    private int getNextPrimeNumber(int currentNum){
        int result = 0;
        for (int i = currentNum + 1; true; i++){
            for (int j = 2; j <= 9; j++){
                if (i % j == 0) {
                    if (j == i) result = i;
                    break;
                }
                else if (j == 9) result = i;
            }
            if (result != 0) break;
        }
        return result;
    }

    @Override
    public String toString() {
        sb.delete(0, sb.length());
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                sb.append(keys[i] + " :");
                Node x = (Node) keys[i];
                while (x != null){
                    sb.append(" " + x.value);
                    x = x.next;
                }
                sb.append("\n");
            }
        }
        //sb.append(Arrays.toString(keys) + "\n" );
        return sb.toString();
    }
}
