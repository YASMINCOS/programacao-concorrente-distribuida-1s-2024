package aula04;

public class Incrementer extends Thread {
    private Count count;

    public Incrementer(Count count) {
        this.count = count;
    }

    public void run() {
        System.out.println(this.getName() + " incrementando contador...");
        this.count.increment();
    }
}
