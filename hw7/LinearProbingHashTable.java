package hw7;

import java.util.Arrays;

public class LinearProbingHashTable<Key, Value> {

    private int M = 3;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];
    private int size = 0;
    private StringBuilder sb = new StringBuilder();

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
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) if (((Key)keys[i]).equals(key)) return (Value) values[i];
        return null;
    }

    public void put (Key key, Value value){
        if (key == null) throw new IllegalArgumentException("Ключ не должен быть null");
        int i;
        if (size == M) resize();
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((Key)keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value remove(Key key){
        if (!contains(key)) throw new IllegalArgumentException("Указанного ключа не существует");
        Value temp;
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((Key)keys[i]).equals(key)) {
                temp = (Value) values[i];
                keys[i] = null;
                values[i] = null;
                size--;
                return temp;
            }
        }
        return null;
    }

    private void resize(){
        int oldLength = M;
        M = getNextPrimeNumber(M);
        Object[] tempKeys = keys;
        Object[] tempValues = values;
        keys = new Object[M];
        values = new Object[M];
        size = 0;
        for (int i = 0; i < oldLength; i++) if (tempKeys[i] != null) put((Key) tempKeys[i],(Value) tempValues[i]);
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
        //for (int i = 0; i < keys.length; i++) if (keys[i] != null) sb.append(keys[i] + " - " + values[i] + "\n");
        sb.append(Arrays.toString(keys) + "\n" + Arrays.toString(values));
        return sb.toString();
    }
}
