import java.util.concurrent.Semaphore;

public class Carro implements Runnable {
    private int numero;
    private Semaphore semaphore;

    public Carro(int numero, Semaphore semaphore) {
        this.numero = numero;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Carro " + numero + " chegou ao estacionamento.");

        try {
            // Adquirindo uma vaga no estacionamento
            semaphore.acquire();
            System.out.println("Carro " + numero + " estacionou.");

            // Simulando o tempo que o carro permanece no estacionamento (entre 1 e 5 segundos)
            int tempoEstacionado = (int) (1 + Math.random() * 5);
            Thread.sleep(tempoEstacionado * 1000);

            // Liberando a vaga no estacionamento
            semaphore.release();
            System.out.println("Carro " + numero + " saiu do estacionamento após " + tempoEstacionado + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
