package aula05;

public class Count {
    private Integer value;

    public Count(Integer value) {
        this.value = value;
    }

    public synchronized void increment() {
       System.out.println("Entrando no metodo increment... " );
        this.value++;
       System.out.println("Incrementou o valor para final do contador: " + this.value);
      System.out.println("Saindo no metodo increment... " );
    }

    public Integer getValue() {
        return this.value;
    }
}
