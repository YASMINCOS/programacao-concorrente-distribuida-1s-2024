package aula07.jantar;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Filosofos extends Thread{

    private Prato prato;
    private Semaphore semaphoreJantar;
    private Lock garfoEsq;
    private Lock garfoDir;

    public Filosofos(Prato prato,Semaphore semaphoreJantar, Lock garfoEsq, Lock garfoDir){
        this.prato = prato;
        this.semaphoreJantar = semaphoreJantar;
        this.garfoDir = garfoDir;
        this.garfoEsq = garfoEsq;
    }
    
    public void run(){

    }
}
