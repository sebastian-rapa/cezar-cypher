package ro.sebastianrapa;

import java.util.Scanner;

public class CezarApplication {

    private static int CYPHER_SALT_NUMBER;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        // First Set cypher nu,ber
        setCypherNumber();
        // Print menu
        printMenu();

        // Get user option
        int option = getUserOption();
        String encryptedText = null;
        while (!Option.isExit(option)) {
            switch (Option.values()[option - 1]) {
                case ENCRYPT:
                    String textToEncrypt = fetchUserInput();
                    encryptedText = CezarCypher.encrypt(textToEncrypt, CYPHER_SALT_NUMBER);
                    System.out.printf("You introduced: %s%nEncrypted text: %s%n", textToEncrypt, encryptedText);
                    break;
                case DECRYPT:
                    if (encryptedText == null) {
                        System.out.println("First encrypt a text than you can decrypt it!");
                        break;
                    }
                    String decryptedText = CezarCypher.decrypt(encryptedText, CYPHER_SALT_NUMBER);
                    System.out.printf("Text to decrypt: %s%nDecrypted text: %s%n", encryptedText, decryptedText);
                    break;
                case SET_CYPHER_NUMBER:
                    setCypherNumber();
                    break;
                case EXIT:
                    System.out.println("Exiting Cezar Cypher");
                    break;
            }
            printMenu();
            option = getUserOption();
        }
    }

    private static String fetchUserInput() {
        System.out.printf("Enter a text to encrypt%n> ");
        return SCANNER.next();
    }

    private static int getUserOption() {
        int userOption;
        while (true) {
            try {
                System.out.print("> ");
                userOption = Integer.valueOf(SCANNER.next());
                if (!Option.isValidOption(userOption)) {
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid cypher number");
            }
        }
        return userOption;
    }

    private static void printMenu() {
        System.out.println("Choose one of the following options");
        System.out.println("1) Encrypt text");
        System.out.println("2) Decrypt text");
        System.out.println("3) Set cypher");
        System.out.println("4) Exit");
    }

    private static void setCypherNumber() {
        System.out.println("Setting shift number for encrypting text");

        int cypherNumberFromUser;
        while (true) {
            try {
                System.out.println("Enter shift number: ");
                System.out.print("> ");
                cypherNumberFromUser = Integer.valueOf(SCANNER.next());
                if (cypherNumberFromUser < 1 || cypherNumberFromUser > 25) {
                    System.out.printf("Please enter a valid cypher number in the interval: [1:25]%n%n");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid cypher number");
            }
        }
        CYPHER_SALT_NUMBER = cypherNumberFromUser;

    }
}
