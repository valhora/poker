package poker.model;

import java.util.*;

/**
 * Representa uma mão de cartas
 *
 * em um primeira etapa são obtidos as combinações de cartas notáveis
 * pares, trio e quarteto e ordenação das cartas que podem fazer parte de uma desempate.
 * Em uma segunda etapa são varificadas as combinações para formação do ranking e atribuição das cartas de desmpate.
 *
 */
public class Mao implements Comparable<Mao>{

    private static final int QTD_CARTAS = 5;
    public ArrayList<Carta> cartas;
    private ArrayList<Carta> cartasOrdenadas;
    public ArrayList<Carta> cartasRank;
    private RankingEnum ranking;
    private IBaralho baralho;

    public Mao(IBaralho baralho) {
        this.baralho = baralho;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public Carta getHighCard() {
        return cartasOrdenadas.get(0);
    }

    /**
     * preenche a mão com cartas do baralho
     */
    public ArrayList<Carta> pegaCartas() {
        cartas = baralho.darCartas(QTD_CARTAS);
        setCartas(cartas);
        return this.cartas;
    }

    /**
     * atribui cartas à mão
     * @param cartas ArrayList<Carta>
     */
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
        cartasOrdenadas = new ArrayList<Carta>();
        cartasOrdenadas.addAll(cartas);
        Collections.sort(cartasOrdenadas);
        setRanking();
    }

    public RankingEnum getRanking() {
        return ranking;
    }


    /**
     * atribui o ranking e caras de desempate para a mão
     */
    private void setRanking() {

        cartasRank = new ArrayList<Carta>();
        Carta par1 = null;
        Carta par2 = null;
        Carta trio = null;
        Carta quarteto = null;
        ArrayList<Carta> restantes = new ArrayList<Carta>();


        HashSet<Carta> hashSet = new HashSet<Carta>(cartasOrdenadas);
        ArrayList<Carta> valoresDiferentes = new ArrayList<Carta>(hashSet);

        Collections.sort(valoresDiferentes);

        for (Carta carta:valoresDiferentes) {

            int qtd = Collections.frequency(cartas,carta);
            switch (qtd) {

                case 1: restantes.add(carta);
                        break;

                case 2: if(par1 == null){
                            par1 = carta;
                        }else {
                            if(par1.compareTo(carta) > 1){
                                par2 = par1;
                                par1 = carta;
                            }else{
                                par2 = carta;
                            }
                        }
                        break;
                case 3: trio = carta;
                        break;

                case 4: quarteto = carta;
                        break;
            }

        }


       //STRAIGHT_FLUSH
        if (restantes.size() == 5 &&
                cartasOrdenadas.get(0).getValor() - cartasOrdenadas.get(4).getValor() == 4 &&
                isMesmoNaipe()) {

            ranking = RankingEnum.STRAIGHT_FLUSH;
            cartasRank.add(cartasOrdenadas.get(0));
            return;
        }

        //FOUR_OF_A_KIND
        if (quarteto != null) {
            ranking =  RankingEnum.FOUR_OF_A_KIND;
            cartasRank.add(quarteto);
            return;
        }

        //FULL_HOUSE
        if (trio != null && par1 != null) {
            ranking =  RankingEnum.FULL_HOUSE;
            cartasRank.add(trio);
            return;
        }

        //FLUSH
        if (isMesmoNaipe()) {
            ranking =  RankingEnum.FLUSH;
            cartasRank.add(cartasOrdenadas.get(0));
            return;
        }

        //STRAIGHT
        if (restantes.size() == 5 &&
                cartasOrdenadas.get(0).getValor() - cartasOrdenadas.get(4).getValor() == 4) {
            ranking =  RankingEnum.STRAIGHT;
            cartasRank.add(cartasOrdenadas.get(0));
            return;
        }

        //THREE_OF_A_KIND
        if (trio != null) {
            ranking =  RankingEnum.THREE_OF_A_KIND;
            cartasRank.add(trio);
            return;
        }

        //TWO_PAIRS
        if (par1 != null && par2 != null) {
            ranking =  RankingEnum.TWO_PAIRS;
            cartasRank.add(par1);
            cartasRank.add(par2);
            cartasRank.addAll(restantes);
            return;
        }

        //PAIRS
        if (par1 != null) {
            ranking =  RankingEnum.PAIRS;
            cartasRank.add(par1);
            cartasRank.addAll(restantes);
            return;
        }

        ranking =  RankingEnum.HIGH_CARD;
        cartasRank.addAll(cartasOrdenadas);

    }

    /**
     * verifica se toas as cartas da mão são do mesmo naipe
     *
     */
    private boolean isMesmoNaipe(){
        NaipeEnum currentNaipe = cartas.get(0).getNaipe();
        for (int i = 1; i < cartas.size(); i++) {
            if (currentNaipe != cartas.get(i).getNaipe()) {
                return false;
            }
        }
        return true;
      }

    /**
     * comparação feita entre o ranking e cartas de desempate
     *
     */
    public int compareTo(Mao o) {
        if (this.getRanking().getValue() > o.getRanking().getValue()) {
            return -1; //before
        } else if (this.getRanking().getValue() < o.getRanking().getValue()) {
            return 1; //after
        } else {
            for (int i = 0; i < this.cartasRank.size(); i++) {
                if (this.cartasRank.get(i).compareTo(o.cartasRank.get(i)) > 0) {
                    return -1; //before
                } else if (this.cartasRank.get(i).compareTo(o.cartasRank.get(i)) < 0) {
                    return 1; //after
                }
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(cartas.get(0).toString());
        for (int i = 1; i < cartas.size() ; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(cartas.get(i).toString());
        }
        stringBuilder.append(" - ");
        stringBuilder.append(this.getRanking().toString());
        return stringBuilder.toString();
    }
}
