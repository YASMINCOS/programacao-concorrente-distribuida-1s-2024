package aula05.exercicio;

import java.util.concurrent.ThreadLocalRandom;

public class Received extends Thread {
    private Data packet;

    public Received(Data packet){
        this.packet = packet;
    }
    
    public void run(){
        while (true) {
            String message = this.packet.receive();
            System.out.println("Mesnagem recebida " + message);
             
            if (message == "END") {
                break;
            }
            
            int randomDelay = ThreadLocalRandom.current().nextInt(3000,7000);

            try {
                Thread.sleep(randomDelay);
            } catch (Exception e) {
                System.out.println("Thread foi interrompida!");
            }
            
        }
    }
}
