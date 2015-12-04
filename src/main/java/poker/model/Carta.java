package poker.model;

/**
 * Representa uma carta do baralho
 */
public class Carta {
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


    @Override
    public String toString() {
        //return valor.getLabel() + " de " + naipe.getLabel();
        return valor.getValue() +naipe.getLabel();
    }
}
