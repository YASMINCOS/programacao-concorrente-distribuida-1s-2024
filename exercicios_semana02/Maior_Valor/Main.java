package exercicios_semana02.Maior_Valor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(20);
        numbers.add(35);
        numbers.add(15);
        numbers.add(45);
        numbers.add(25);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> maxValueFinder = new MaxValueFinder(numbers);

        Future<Integer> future = executor.submit(maxValueFinder);

        try {
            int maxValue = future.get();
            System.out.println("Maior valor da lista: " + maxValue);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
