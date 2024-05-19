package semaforos_estudos.jantas_filosofos;

public class Garfo {
    private boolean disponivel = true;

    public synchronized void pegar() throws InterruptedException {
        while (!disponivel) {
            wait();
        }
        disponivel = false;
    }

    public synchronized void liberar() {
        disponivel = true;
        notifyAll();
    }
}
