package hw4;

public class Main {
    public static void main(String[] args) {

        PowerOfNumber pw = new PowerOfNumber();
        int a = 3;
        for (int i = 0; i < 6; i++) System.out.println(pw.numPow(a, i));
        for (int i = 0; i < 6; i++) System.out.println(pw.numPowRec(a, i));
        for (int i = 0; i < 6; i++) System.out.println(pw.numPowFastRec(a, i));

        double start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) pw.numPowFastRec(a, i);
        System.out.println((System.currentTimeMillis() - start) / 1000);

        HanoiTower hanoiTower = new HanoiTower(8);
        hanoiTower.print();
        hanoiTower.moveRec();
        hanoiTower.print();

    }

}
