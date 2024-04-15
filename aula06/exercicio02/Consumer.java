package aula06.exercicio02;

import java.util.Random;

public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer, String name) {
        super(name); // chamar construtor da class pai(thread)
        this.buffer = buffer;

    }

    public void run() {
        // cosnumir entre 1 a 5 produtos por vez
        int numProdutos = new Random().nextInt(5) + 1;

        System.out.println(this.getName() + "produtor consumiu " + numProdutos);

        for (int i = 0; i < numProdutos; i++) {
            this.consume();
        }
        System.out.println(this.getName() + "terminou o consumo");
    }

    public void consume() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida");
        }
        this.buffer.remove();

    }
}
