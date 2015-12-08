package poker.model;

/**
 * Representa uma carta do baralho
 */
public class Carta implements Comparable<Carta> {
    private final ValorEnum valor;
    private final NaipeEnum naipe;

    /**
     *
     * @param valor ValorEnum
     * @param naipe NaipeEnum
     */
    public Carta(ValorEnum valor, NaipeEnum naipe){
        this.valor = valor;
        this.naipe = naipe;
    }

    public ValorEnum getValorEnum() {
        return valor;
    }

    public int getValor() {
        return valor.getValue();
    }

    public NaipeEnum getNaipe() {
        return naipe;
    }

    @Override
    public String toString() {
        return valor.getLabel() + naipe.getLabel();
    }

    /**
     * Ordenado do maior para o menor
     *
     */
    public int compareTo(Carta o) {
        if (this.valor.getValue() > o.valor.getValue()) {
            return -1; //before
        } else if (this.valor.getValue() < o.valor.getValue()) {
            return 1; //after
        } else {
            return 0;
        }
    }

    /**
     * Assumindo que para efeitos de comparação de rank o naipe não é utilizado
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carta carta = (Carta) o;

        return valor == carta.valor;

    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}
