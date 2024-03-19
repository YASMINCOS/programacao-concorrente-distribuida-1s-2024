
package aula02_threads;

public class Tchau extends Thread{

    public void run(){
       System.out.println(this.getName() + "Aqui comeca a thread Tchau");
       System.out.println("Tchau");
    }
   
}