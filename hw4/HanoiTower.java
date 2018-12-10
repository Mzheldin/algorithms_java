package hw4;

import hw3.MyLinkedListStack;

public class HanoiTower {

    private MyLinkedListStack<Integer> pin1 = new MyLinkedListStack<>();
    private MyLinkedListStack<Integer> pin2 = new MyLinkedListStack<>();
    private MyLinkedListStack<Integer> pin3 = new MyLinkedListStack<>();

    private int length;
    private int turns;

    public HanoiTower(int n){
        create(n);
    }

    public void create(int n){
        length = n;
        for (int i = n; i > 0; i--) pin1.push(i);
        pin2.clearStack();
        pin3.clearStack();
        turns = 0;
    }

    public void moveRec(){
        resultRec(length, pin1, pin2, pin3);
    }

    private void resultRec(int n, MyLinkedListStack<Integer> currentPin, MyLinkedListStack<Integer> targetPin,  MyLinkedListStack<Integer> offPin){
        if (n == 0){ return; }
        turns++;
        resultRec(n - 1, currentPin, offPin, targetPin);
        targetPin.push(currentPin.pop());
        resultRec(n - 1, offPin, targetPin, currentPin);
    }

    public void move(){
        if (length % 2 == 0){
            while (pin3.size() != length) {
                if (pin2.isEmpty()) pin2.push(pin1.pop());
                else if (!pin1.isEmpty() && pin1.peek() < pin2.peek()) pin2.push(pin1.pop());
                else pin1.push(pin2.pop());
                if (pin3.isEmpty() || pin1.peek() < pin3.peek()) pin3.push(pin1.pop());
                else pin1.push(pin3.pop());
                if (pin2.peek() < pin3.peek()) pin3.push(pin2.pop());
                else pin2.push(pin3.pop());
            }
        } else {
            while (pin3.size() != length) {
                if (pin3.isEmpty()) pin3.push(pin1.pop());
                else if (!pin1.isEmpty() && pin1.peek() < pin3.peek()) pin3.push(pin1.pop());
                else pin1.push(pin3.pop());
                if (pin3.size() == length) break;
                if (pin2.isEmpty() || (!pin1.isEmpty() && pin1.peek() < pin2.peek())) pin2.push(pin1.pop());
                else pin1.push(pin2.pop());
                if (pin2.peek() < pin3.peek()) pin3.push(pin2.pop());
                else pin2.push(pin3.pop());
            }
        }
    }

    public void print() {
        System.out.println("количество ходов " + turns);
        System.out.println("первая ось " + pin1.toString());
        System.out.println("вторая ось " + pin2.toString());
        System.out.println("третья ось " + pin3.toString());
    }
}
