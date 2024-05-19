package exercicios_semana02.Primos;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int startRange = 1;
        int endRange = 20;

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> primeSumCalculator = new PrimeSumCalculator(startRange, endRange);

        Future<Integer> future = executor.submit(primeSumCalculator);

        try {
            int primeSum = future.get();
            System.out.println("Soma dos números primos no intervalo: " + primeSum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
