package aula05.exercicio;

import java.util.concurrent.ThreadLocalRandom;

public class Sender extends Thread {
    private Data packet;
    private String[] messages;

    public Sender(Data packe, String[] messages) {
        this.packet = packet;
        this.messages = messages;
    }

    public void run() {
        // para cada mensagem na lista de mensagens
        for (String string : this.messages) {
            System.out.println("Mensagem enviada " + string);

            packet.send(string);
            ///// gerando um valor de 3 a 7 segundos
            int randomDelay = ThreadLocalRandom.current().nextInt(3000, 7000);

            try {
                Thread.sleep(randomDelay);
            } catch (Exception e) {
                System.out.println("Thread foi interrompida!");
            }

        }
    }
}
