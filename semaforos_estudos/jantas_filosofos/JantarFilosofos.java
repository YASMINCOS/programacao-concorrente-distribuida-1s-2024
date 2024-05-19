package semaforos_estudos.jantas_filosofos;

import java.util.concurrent.Semaphore;

public class JantarFilosofos {
    public static final int NUM_FILOSOFOS = 5;
    private static final int MAX_ITERACOES = 10; // Número máximo de iterações

    public static void main(String[] args) {
        Semaphore[] garfos = new Semaphore[NUM_FILOSOFOS];

        // Inicializa os semáforos dos garfos
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            garfos[i] = new Semaphore(1);
        }

        // Variável compartilhada para acompanhar quantos filósofos já terminaram de comer
        int filosofosQueComeram = 0;

        // Inicia threads para cada filósofo
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Filosofo filosofo = new Filosofo(i, garfos, MAX_ITERACOES, filosofosQueComeram);
            Thread threadFilosofo = new Thread(filosofo);
            threadFilosofo.start();
        }
    }
}
