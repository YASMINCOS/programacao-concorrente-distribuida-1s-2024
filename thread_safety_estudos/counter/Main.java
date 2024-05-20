package thread_safety_estudos.counter;

public class Main {
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();

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

        // Imprimindo o valor final do contador
        System.out.println("Valor final do contador: " + counter.getCount());
    }
}
