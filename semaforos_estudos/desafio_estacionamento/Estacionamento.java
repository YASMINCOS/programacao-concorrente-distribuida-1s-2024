package semaforos_estudos.desafio_estacionamento;

import java.util.concurrent.Semaphore;

public class Estacionamento {
    public static void main(String[] args) {
        // Criando dois semáforos para controlar o acesso aos estacionamentos
        Semaphore semaforoEstacionamento1 = new Semaphore(10);
        Semaphore semaforoEstacionamento2 = new Semaphore(10);

        // Criando o gerenciador de estacionamentos e iniciando threads para os carros
        GerenciadorEstacionamento gerenciador = new GerenciadorEstacionamento(semaforoEstacionamento1, semaforoEstacionamento2);
        for (int i = 1; i <= 50; i++) {
            Carro carro = new Carro(i, gerenciador);
            Thread threadCarro = new Thread(carro);
            threadCarro.start();
        }
    }
}
