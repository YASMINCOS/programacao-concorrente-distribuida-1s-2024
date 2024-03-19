 package aula02_threads;

 public class Ola extends Thread{

     public void run(){
        System.out.println(this.getName() + "Aqui comeca a thread Ola");
        System.out.println("Ola");
     }
    
}