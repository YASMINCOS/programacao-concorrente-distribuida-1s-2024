package thread_safety_estudos.counter;

public class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();

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
        System.out.println("Valor final do contador (synchronized): " + counter.getCount());
        System.out.println("Tempo de execução (synchronized): " + (endTime - startTime) + " nanossegundos");
    }
}
