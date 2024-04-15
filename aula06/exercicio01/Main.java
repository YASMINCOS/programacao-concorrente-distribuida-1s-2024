package aula06.exercicio01;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Integer numExec = 0;
        // simular contador com valor diferente
        while (true) {
            ReentrantLock lock = new ReentrantLock();
            Count count = new Count(0, lock);

            Incrementer incrementer = new Incrementer(count);
            Incrementer incrementer1 = new Incrementer(count);
            Incrementer incrementer2 = new Incrementer(count);
            Incrementer incrementer3 = new Incrementer(count);

            incrementer.start();
            incrementer1.start();
            incrementer2.start();
            incrementer3.start();

            try {
                incrementer.join();
                incrementer1.join();
                incrementer2.join();
                incrementer3.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            numExec++;
            if (count.getValue() != 4) {
                System.out.println("Numero de execucoes: " + numExec);
                System.out.println("Valor final do contador: " + count.getValue());
                break;
            }

        }

    }
}
