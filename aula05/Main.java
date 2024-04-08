package aula05;

public class Main {

    public static void main(String[] args) {
        Integer numExec = 0;
        // simular contador com valor diferente
        while (true) {
            Count count = new Count(0);

            Incrementer incrementer = new Incrementer(count);
            Incrementer incrementer1 = new Incrementer(count);
            Incrementer incrementer2 = new Incrementer(count);
            Incrementer incrementer3 = new Incrementer(count);

            incrementer.start();
            incrementer1.start();
            incrementer2.start();
            incrementer3.start();

            try {
                incrementer.join();
                incrementer1.join();
                incrementer2.join();
                incrementer3.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            numExec++;
            if (count.getValue() != 4) {
                System.out.println("Numero de execucoes: " + numExec);
                System.out.println("Valor final do contador: " + count.getValue());
                break;
            }

        }

    }
}
