package poker.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Representa o baralho de 52 cartas
 */
public class Baralho implements IBaralho {
    public ArrayList<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<Carta>();
        for (ValorEnum valor : ValorEnum.values()) {
            for (NaipeEnum naipe : NaipeEnum.values())
                cartas.add(new Carta(valor, naipe));
        }
    }

    public int size() {
        return cartas.size();
    }

    /**
     * Embaralha as cartas
     */
    public void embaralha() {
        Collections.shuffle(cartas);
    }

    /**
     *
     * Retorna a quantidades de cartas informadas no parâmetro "quantidade" e retira estas cartas do baralho
     *
     * @param quantidade int
     * @return ArrayList<Carta>
     */
    public ArrayList<Carta> darCartas(int quantidade){
        ArrayList<Carta> ct = new ArrayList<Carta>();

        for (int i = 0; i < quantidade ; i++) {
            ct.add(cartas.remove(0));
        }
        return ct;
    }

}


