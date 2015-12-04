package poker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma mão de cartas
 */
public class Mao {

    private static final int QTD_CARTAS = 5;
    private IBaralho baralho;
    public ArrayList<Carta> cartas;

    public Mao(IBaralho baralho) {
        this.baralho = baralho;
    }

    /**
     *
     * preenche a mão com cartas do baralho
     */
    public ArrayList<Carta> pegaCartas(){
        cartas = baralho.darCartas(QTD_CARTAS);
        return cartas;
    }


}
