package thread_safety_estudos.counter;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();

        long startTime = System.nanoTime();

        // Criando e iniciando várias threads para incrementar o contador
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Esperando todas as threads terminarem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();

        // Imprimindo o valor final do contador e o tempo de execução
        System.out.println("Valor final do contador (Atomic): " + counter.getCount());
        System.out.println("Tempo de execução (Atomic): " + (endTime - startTime) + " nanossegundos");
    }
}
