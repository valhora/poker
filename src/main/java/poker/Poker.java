package poker;

import poker.model.Baralho;
import poker.model.Mao;

/**
 * Utilizado para retorno do webservice
 */
public class Poker {

    public String black;
    public String white;
    public String result;

    public Poker() {
        Baralho baralho = new Baralho();
        baralho.embaralha();
        Mao mBlack = new Mao(baralho);
        Mao mWhite = new Mao(baralho);

        mBlack.pegaCartas();
        mWhite.pegaCartas();

        black = mBlack.toString();
        white = mWhite.toString();


        if (mBlack.compareTo(mWhite) < 0) {
            result = "White wins " + mWhite.getRanking().toString();
        }else if (mBlack.compareTo(mWhite) > 0){
            result = "Black wins " + mBlack.getRanking().toString();
        }else{
            result ="Tie";
        }

    }
}
