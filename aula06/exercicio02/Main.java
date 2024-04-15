package aula06.exercicio02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static int NUM_PRODUCERS = 4;
    private static int NUM_CONSUMERS = 2;

    public static void main(String[] args) {

        Queue<Integer> productsQueue = new LinkedList<Integer>();
        Lock lock = new ReentrantLock();

        Buffer buffer = new Buffer(productsQueue, lock);

        for (int i = 0; i < NUM_PRODUCERS; i++) {
            new Producer(buffer, "produtor " + (i + 1)).start();
        }
        for (int i = 0; i < NUM_CONSUMERS; i++) {
            new Consumer(buffer, "produtor " + (i + 1)).start();
        }
    }
}
