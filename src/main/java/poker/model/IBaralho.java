package poker.model;

import java.util.ArrayList;

public interface IBaralho {
    int size();

    void embaralha();

    ArrayList<Carta> darCartas(int quantidade);
}
