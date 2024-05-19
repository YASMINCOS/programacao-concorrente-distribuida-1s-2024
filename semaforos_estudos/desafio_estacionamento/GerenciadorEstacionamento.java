package semaforos_estudos.desafio_estacionamento;

import java.util.concurrent.Semaphore;

public class GerenciadorEstacionamento {
    private Semaphore semaforoEstacionamento1;
    private Semaphore semaforoEstacionamento2;

    public GerenciadorEstacionamento(Semaphore semaforoEstacionamento1, Semaphore semaforoEstacionamento2) {
        this.semaforoEstacionamento1 = semaforoEstacionamento1;
        this.semaforoEstacionamento2 = semaforoEstacionamento2;
    }

    public void estacionarCarro(Carro carro) {
        Semaphore semaforoMenorFila = semaforoEstacionamento1.getQueueLength() <= semaforoEstacionamento2.getQueueLength() ?
                                       semaforoEstacionamento1 : semaforoEstacionamento2;

        // Variáveis para armazenar a quantidade de carros em cada estacionamento
        int vagasEstacionamento1 = 10 - semaforoEstacionamento1.availablePermits();
        int vagasEstacionamento2 = 10 - semaforoEstacionamento2.availablePermits();

        try {
            // Adquirindo uma vaga no estacionamento com a fila mais curta
            semaforoMenorFila.acquire();
            System.out.println("Carro " + carro.getNumero() + " estacionou no Estacionamento " +
                               (semaforoMenorFila == semaforoEstacionamento1 ? "1" : "2") + ".");

            // Simulando o tempo que o carro permanece no estacionamento (entre 1 e 5 segundos)
            int tempoEstacionado = (int) (1 + Math.random() * 5);
            Thread.sleep(tempoEstacionado * 1000);

            // Liberando a vaga no estacionamento
            semaforoMenorFila.release();
            System.out.println("Carro " + carro.getNumero() + " saiu do Estacionamento " +
                               (semaforoMenorFila == semaforoEstacionamento1 ? "1" : "2") +
                               " após " + tempoEstacionado + " segundos.");

            // Imprimindo qual estacionamento está mais cheio
            if (vagasEstacionamento1 > vagasEstacionamento2) {
                System.out.println("Estacionamento 1 está mais cheio.");
            } else if (vagasEstacionamento2 > vagasEstacionamento1) {
                System.out.println("Estacionamento 2 está mais cheio.");
            } else {
                System.out.println("Os estacionamentos estão com a mesma quantidade de carros.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
