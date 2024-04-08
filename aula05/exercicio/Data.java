package aula05.exercicio;

public class Data {
    private String message;
    private boolean isSending = true;

    public synchronized void send(String message) {
        // enquanto o recebimento nao termina eu espero
        while (!isSending) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread foi interrompida");
            }
        }
        //posso enviar a mensagem
        this.message = message;

        //ja enviei, nao to mais enviando
        isSending = false;

        //aviso para a thread de recebimento que o envio terminou
        notify();
    }

    public synchronized String receive() {
        while (isSending) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread foi interrompida");
            }
        }
        //poso receber minha mensagem
        String receivedMessage = this.message;

        //ja recebi, pode enviar a proxima mensagem
        isSending = true;

        //aviso para a thread de recebimento que o envio terminou
        notify();

        return receivedMessage;
    }
}
