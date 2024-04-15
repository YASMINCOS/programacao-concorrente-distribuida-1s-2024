package aula06.exercicio01;

import java.util.concurrent.locks.Lock;

public class Count {

    private Integer value;
    private Lock lock;

    public Count(Integer value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    public void increment() {
        //garante que so quando uma thread sair a outra entra
        // bloquando a trava
        this.lock.lock();

        // secao de acesso exclusivo
        System.out.println("Entrando no metodo increment... ");
        this.value++;
        System.out.println("Incrementou o valor para final do contador: " + this.value);
        System.out.println("Saindo no metodo increment... ");

        //libera a trava
        this.lock.unlock();
    }

    public Integer getValue() {
        return this.value;
    }
}
