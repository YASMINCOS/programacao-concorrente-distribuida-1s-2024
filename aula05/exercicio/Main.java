package aula05.exercicio;

public class Main {

    public static void main(String[] args) {
        Data packeData = new Data();
        String[] messaStrings ={
            "primeira mensagem",
            "segunda mensagem",
            "terceira mensagem",
            "END"
        };

        Sender sender = new Sender(packeData, messaStrings);
        Received received = new Received(packeData);
    
        sender.start();
        received.start();
    }
    
}
