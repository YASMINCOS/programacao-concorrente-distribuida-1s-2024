package estudos_sockets.criptografia_mensagens;

public class CifraCesar {
    private static final int SHIFT = 3; // Número de posições para deslocar

    // Função para criptografar uma string
    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) ((character - base + SHIFT) % 26 + base);
            }
            result.append(character);
        }
        return result.toString();
    }

    // Função para descriptografar uma string
    public static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) ((character - base - SHIFT + 26) % 26 + base);
            }
            result.append(character);
        }
        return result.toString();
    }
}

