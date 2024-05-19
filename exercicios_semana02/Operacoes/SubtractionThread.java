package exercicios_semana02.Operacoes;

import java.util.concurrent.Callable;

public class SubtractionThread implements Callable<Integer> {
    private int num1;
    private int num2;

    public SubtractionThread(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public Integer call() {
        return num1 - num2;
    }
}
