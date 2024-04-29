package aula07.estacionamento;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        //10 permissoes, ou seja, apenas 10 carros podem estar no estacionamento simultaneamente
        Semaphore estacionamento = new Semaphore(10);

        for(int i = 0; i< 20; i++){
            new Carro("carro " + i, estacionamento).start();
        }
    }
}
