package poker.model;

/**
 * Representa os naipes do baralho
 */
public enum NaipeEnum {
    PAUS("Paus","P"),
    COPAS("Copas","C"),
    OUROS("Ouros","O"),
    ESPADAS("Espadas","E");

    private final String nome;
    private final String label;

    NaipeEnum(String nome, String label) {
        this.label = label;
        this.nome = nome;
    }

    public String getLabel() {
        return label;
    }

    public String getNome() {
        return nome;
    }
}
