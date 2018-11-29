package hw1;

import java.text.DecimalFormat;

public class Main {

    public enum SortType {SELECT, INSERT, BUBBLE}

    public static void main(String[] args) {

        MyArrayList<Integer> myArr = new MyArrayList<>();
        for (int i = 0; i < 10000; i++) myArr.insert((int) (Math.random() * 1000));

        System.out.println("Среднее время сортировки вставкой, мс : " + new DecimalFormat("#0.00").format(SortTimeInt(myArr, 1000, SortType.INSERT)));
        System.out.println("Среднее время сортировки выборкой, мс : " + new DecimalFormat("#0.00").format(SortTimeInt(myArr, 1000, SortType.SELECT)));
        System.out.println("Среднее время сортировки пузырьком, мс : " + new DecimalFormat("#0.00").format(SortTimeInt(myArr, 1000, SortType.BUBBLE)));
    }

    public static double SortTimeInt(MyArrayList<Integer> arr, int num, SortType sortType){
        long sumTime = 0;
        MyArrayList<Integer> copyArr;
        for (int i = 0; i < num; i++){
            copyArr = arr.copy();
            long start = System.nanoTime();
            switch (sortType){
                case BUBBLE: arr.bubbleSort();
                                break;
                case INSERT: arr.insertionSort();
                                break;
                case SELECT: arr.selectionSort();
                                break;
            }
            sumTime += (System.nanoTime() - start);
            copyArr.clear();
        }
        return (sumTime / 1000000.0) / num;
    }
}
