package poker.model;

/**
 * Representa as classificações de uma mão
 */
public enum RankingEnum {
    HIGH_CARD("High Card", 9),
    PAIRS("Pairs", 8),
    TWO_PAIRS("Two Pairs", 7),
    THREE_OF_A_KIND("Three of Kin", 6),
    STRAIGHT("Straight", 5),
    FLUSH("Flush", 4),
    FULL_HOUSE("Full House", 3),
    FOUR_OF_A_KIND("Four of a kind", 24),
    STRAIGHT_FLUSH("Straight Flush", 1);

    private final String label;
    private final int value;

    RankingEnum(String label, int value) {
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
