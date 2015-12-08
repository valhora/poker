package poker.model;

/**
 * Representa os valores das cartas
 */
public enum ValorEnum {
    AS("A", 14),
    REI("K", 13),
    DAMA("Q", 12),
    VALETE("J", 11),
    DEZ("10", 10),
    NOVE("9", 9),
    OITO("8", 8),
    SETE("7", 7),
    SEIS("6", 6),
    CINCO("5", 5),
    QUATRO("4", 4),
    TRES("3", 3),
    DOIS("2", 2);


    private final String label;
    private final int value;

    ValorEnum(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

}
