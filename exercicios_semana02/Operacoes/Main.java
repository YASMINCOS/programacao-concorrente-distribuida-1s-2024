package exercicios_semana02.Operacoes;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        // Criando uma ThreadPool para execução paralela das threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Threads para cada operação aritmética
        SubtractionThread subtractionThread = new SubtractionThread(num1, num2);
        DivisionThread divisionThread = new DivisionThread(num1, num2);
        AdditionThread additionThread = new AdditionThread(num1, num2);
        MultiplicationThread multiplicationThread = new MultiplicationThread(num1, num2);

        // Executando as threads
        Future<Integer> subtractionResult = executor.submit(subtractionThread);
        Future<Integer> divisionResult = executor.submit(divisionThread);
        Future<Integer> additionResult = executor.submit(additionThread);
        Future<Integer> multiplicationResult = executor.submit(multiplicationThread);

        // Aguardando e imprimindo os resultados
        try {
            System.out.println("Resultado da subtração: " + subtractionResult.get());
            System.out.println("Resultado da divisão: " + divisionResult.get());
            System.out.println("Resultado da adição: " + additionResult.get());
            System.out.println("Resultado da multiplicação: " + multiplicationResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Encerrando a ThreadPool
        executor.shutdown();
    }
}


//Callable é uma interface funcional em Java que é semelhante à interface Runnable, exceto pelo fato de que pode retornar um resultado e pode lançar uma exceção. Ela define um método chamado call() que retorna um resultado de um tipo especificado. É amplamente utilizada em conjunção com classes Executor para permitir a execução assíncrona de tarefas e obtenção dos resultados posteriormente.

