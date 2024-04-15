package aula06.exercicio01;

public class Incrementer  extends Thread{
    private Count count;

    public Incrementer(Count count) {
        this.count = count;
    }

    public void run() {
        System.out.println(this+ " incrementando contador...");
        this.count.increment();
        System.out.println(this + " terminhou de incrementar contador...");

    }
}
