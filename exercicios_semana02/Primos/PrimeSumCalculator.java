package exercicios_semana02.Primos;

import java.util.concurrent.Callable;

public class PrimeSumCalculator implements Callable<Integer> {
    private int startRange;
    private int endRange;

    public PrimeSumCalculator(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = startRange; i <= endRange; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
