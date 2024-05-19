package semaforos_estudos.desafio_estacionamento;

public class Carro implements Runnable {
    private int numero;
    private GerenciadorEstacionamento gerenciador;

    public Carro(int numero, GerenciadorEstacionamento gerenciador) {
        this.numero = numero;
        this.gerenciador = gerenciador;
    }

    @Override
    public void run() {
        System.out.println("Carro " + numero + " chegou ao estacionamento.");
        gerenciador.estacionarCarro(this);
    }

    public int getNumero() {
        return numero;
    }
}

