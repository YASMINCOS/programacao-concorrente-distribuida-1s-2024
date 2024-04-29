package aula07.estacionamento;

import java.util.concurrent.Semaphore;

public class Carro extends Thread {

    private Semaphore estacionamento;

    public Carro(String nome, Semaphore estacionamento){
        super(nome);
        this.estacionamento = estacionamento;
    }

    public void run(){
        //regiao critica
        //entrar no estacionamento se tiver vagas disponiveis
        try {
            this.estacionamento.acquire();
            
        } catch (Exception e) {
            System.out.println("Thread interrompida");
        }
        System.out.println(this.getName() + " entrou no estacionamento");
        try {
            //carro fica 10 segundos no estacionamento
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread interrompida");

        }

        System.out.println(this.getName() + " saiu no estacionamento");
        this.estacionamento.release();

        //depois de um tempo deixar o estacionamento

    }
    
}
