package ro.sebastianrapa;

public enum Option {

    ENCRYPT(1),
    DECRYPT(2),
    SET_CYPHER_NUMBER(3),
    EXIT(4);

    private int optionNumber;

    Option(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public static boolean isExit(int option) {
        return EXIT.optionNumber == option;
    }

    public static boolean isValidOption(int userOption) {
        Option[] values = values();
        for (Option value : values) {
            if (value.optionNumber == userOption) {
                return true;
            }
        }
        return false;
    }
}
