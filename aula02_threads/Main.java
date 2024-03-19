 package aula02_threads;

public class Main {
     public static void main(String[] args) throws InterruptedException {
       System.out.println("Inicio Main");

       Ola ola = new Ola();
       Ola ola1 = new Ola();
       Ola ola2 = new Ola();
       Ola ola3 = new Ola();

       Tchau tchau = new Tchau();
       Tchau tchau2 = new Tchau();

       ola1.start();
       ola.start();
       ola2.start();
       ola3.start();

       tchau.start();
       tchau2.join();



    }
    
}