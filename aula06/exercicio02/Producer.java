package aula06.exercicio02;

import java.util.Random;

public class Producer extends Thread {

    private Buffer buffer;

    public Producer(Buffer buffer, String name) {
        super(name); // chamar construtor da class pai(thread)
        this.buffer = buffer;

    }

    public void run() {
        // produzir entre 1 a 5 produtos por vez
        int numProdutos = new Random().nextInt(5) + 1;

        System.out.println(this.getName() + "produtor a producao " + numProdutos);

        for (int i = 0; i < numProdutos; i++) {
            this.produce();
        }
        System.out.println(this.getName() + "terminou a producao");
    }

    public void produce() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida");
        }
        int product= new Random().nextInt(1000);
        this.buffer.add(product);

    }
}