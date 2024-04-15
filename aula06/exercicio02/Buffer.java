package aula06.exercicio02;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buffer {
    static Integer MAX_CAPACITY = 10;

    private Queue<Integer> buffer;
    private Lock lock;
    private Condition bufferIsnotFull;// buffer nao cheio
    private Condition bufferIsnotEmpty;// buffer nao vazio

    public Buffer(Queue<Integer> buffer, Lock lock) {
        this.buffer = buffer;
        this.lock = lock;
    }

    public void add(Integer product) {
        this.lock.lock();

        // enquanto o buffer esta cheito
        while (this.buffer.size() == MAX_CAPACITY) {
            try {
                this.bufferIsnotFull.await();
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida");
            }
            // espero
        }
        System.out.println("Adicionando produto");
        this.buffer.add(product);

        // indico a consumidores que há produtos para consumir
        bufferIsnotEmpty.signalAll();
        this.lock.unlock();
    }

    public void remove() {
        this.lock.lock();

        // enquanto o buffer esta cheito
        while (this.buffer.size() == 0) {
            try {
                this.bufferIsnotEmpty.await();
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida");
            }
            // espero
        }
        System.out.println("Remover produto");
        this.buffer.remove();

        // indico a consumidores que há espaco para produzir
        bufferIsnotFull.signalAll();
        this.lock.unlock();
    }
}
