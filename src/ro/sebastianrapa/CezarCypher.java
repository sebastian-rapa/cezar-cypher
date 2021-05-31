package ro.sebastianrapa;

public class CezarCypher {

    public static String encrypt(String inputToEncrypt, int shiftNumber) {
        // Logic for encrypting the input
        var encryptedOutput = new StringBuilder();
        char[] chars = inputToEncrypt.toCharArray();
        for (char character : chars) {
            int asciCode = character - shiftNumber;
            boolean isSmallCharacter = asciCode >= 97 && asciCode <= 122;
            boolean isBigCharacter = asciCode >= 65 && asciCode <= 90;
            boolean isLetter = isSmallCharacter || isBigCharacter;
            char shiftedCharacter;
            if (isLetter) {
                shiftedCharacter = (char) asciCode;
            } else {
                shiftedCharacter = (char) (asciCode + 26);
            }
            encryptedOutput.append(shiftedCharacter);
        }
        return encryptedOutput.toString();
    }

    public static String decrypt(String inputToEncrypt, int unshiftNumber) {
        // Logic for decrypting the input
        var decryptedOutput = new StringBuilder();
        char[] chars = inputToEncrypt.toCharArray();
        for (char character : chars) {
            int asciCode = character + unshiftNumber;
            boolean isSmallCharacter = asciCode >= 97 && asciCode <= 122;
            boolean isBigCharacter = asciCode >= 65 && asciCode <= 90;
            boolean isLetter = isSmallCharacter || isBigCharacter;
            char unshiftCharacter;
            if (isLetter) {
                unshiftCharacter = (char) asciCode;
            } else {
                unshiftCharacter = (char) (asciCode - 26);
            }
            decryptedOutput.append(unshiftCharacter);
        }
        return decryptedOutput.toString();
    }
}
