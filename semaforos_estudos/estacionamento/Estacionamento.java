import java.util.concurrent.Semaphore;

public class Estacionamento {
    public static void main(String[] args) {
        // Definindo um semáforo para controlar o acesso ao estacionamento
        Semaphore semaphore = new Semaphore(10);

        // Simulando a chegada de 20 carros ao estacionamento
        for (int i = 1; i <= 20; i++) {
            Carro carro = new Carro(i, semaphore);
            Thread threadCarro = new Thread(carro);
            threadCarro.start();
        }
    }
}
