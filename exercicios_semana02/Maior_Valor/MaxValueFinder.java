package exercicios_semana02.Maior_Valor;

import java.util.List;
import java.util.concurrent.Callable;

public class MaxValueFinder implements Callable<Integer> {
    private List<Integer> numbers;

    public MaxValueFinder(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() {
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
