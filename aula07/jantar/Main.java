package aula07.jantar;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Semaphore smeaforoJantar = new Semaphore(4);
        ReentrantLock[] garfos;
        Filosofos [] filosofos = null;

        for(int i = 0; i < 5; i++){
           //   garfos[i] = new ReentrantLock();
        }

        for (int i = 0; i <5 ; i++) {
           // filosofos[i] = new Filosofos(Prato(10), )
            
        }
    }
    
}
