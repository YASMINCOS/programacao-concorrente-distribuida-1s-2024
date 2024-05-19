package semaforos_estudos.jantas_filosofos;

import java.util.concurrent.Semaphore;

public class Filosofo implements Runnable {
    private int id;
    private Semaphore[] garfos;
    private int maxIteracoes;
    private int filosofosQueComeram;
    private int iteracaoAtual;

    public Filosofo(int id, Semaphore[] garfos, int maxIteracoes, int filosofosQueComeram) {
        this.id = id;
        this.garfos = garfos;
        this.maxIteracoes = maxIteracoes;
        this.filosofosQueComeram = filosofosQueComeram;
        this.iteracaoAtual = 0;
    }

    @Override
    public void run() {
        while (filosofosQueComeram < JantarFilosofos.NUM_FILOSOFOS) { // Condição de parada
            try {
                // Filósofo está pensando
                System.out.println("Filósofo " + id + " está pensando.");

                // Tenta pegar o garfo da esquerda
                garfos[id].acquire();
                System.out.println("Filósofo " + id + " pegou o garfo esquerdo.");

                // Tenta pegar o garfo da direita
                garfos[(id + 1) % garfos.length].acquire();
                System.out.println("Filósofo " + id + " pegou o garfo direito.");

                // Filósofo está comendo
                System.out.println("Filósofo " + id + " está comendo.");

                // Libera o garfo da esquerda
                //evitar deadlock, que todos peguem um gargo e nao consigam avancar
                garfos[id].release();
                System.out.println("Filósofo " + id + " liberou o garfo esquerdo.");

                // Libera o garfo da direita
                garfos[(id + 1) % garfos.length].release();
                System.out.println("Filósofo " + id + " liberou o garfo direito.");

                // Incrementa o contador de filósofos que comeram
                synchronized (this) {
                    filosofosQueComeram++;
                }

                // Filósofo terminou de comer e volta a pensar
                Thread.sleep((long) (Math.random() * 1000)); // Tempo aleatório pensando
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
