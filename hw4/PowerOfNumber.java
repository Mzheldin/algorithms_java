package hw4;

public class PowerOfNumber {

    public double numPow(double num, int power){
        if (power == 0) return 1;
        if (power == 1) return num;
        double res = num;
        for (int i = 1; i < power; i++) res *= num;
        return res;
    }

    public double numPowRec(double num, int power){
        if (power == 0) return 1;
        if (power == 1) return num;
        return num * numPowRec(num, power - 1);
    }

    public double numPowFast(double num, int power){
        if (power == 0) return 1;
        if (power == 1) return num;
        double res = num * num;
        double sqr = num * num;
        for (int i = 1; i < power / 2; i++) res *= sqr;
        if (power % 2 == 1) res *= num;
        return  res;
    }

    public double numPowFastRec(double num, int power){
        if (power == 0) return 1;
        if (power == 1) return num;
        if (power % 2 == 0) return numPowFastRec(num * num, power / 2);
        else return num * numPowFastRec(num * num, power / 2);
    }
}
