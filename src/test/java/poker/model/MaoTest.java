package poker.model;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class MaoTest extends TestCase {

    Carta c9P = new Carta(ValorEnum.NOVE,NaipeEnum.PAUS);
    Carta cAP = new Carta(ValorEnum.AS,NaipeEnum.PAUS);

    Carta c5P = new Carta(ValorEnum.CINCO,NaipeEnum.PAUS);
    Carta c10P = new Carta(ValorEnum.DEZ,NaipeEnum.PAUS);
    Carta cVO = new Carta(ValorEnum.VALETE,NaipeEnum.OUROS);
    Carta cDE = new Carta(ValorEnum.DAMA,NaipeEnum.ESPADAS);
    Carta cVP = new Carta(ValorEnum.VALETE,NaipeEnum.PAUS);
    Carta cDP = new Carta(ValorEnum.DAMA,NaipeEnum.PAUS);

    Carta c7C = new Carta(ValorEnum.SETE,NaipeEnum.COPAS);
    Carta c7P = new Carta(ValorEnum.SETE,NaipeEnum.PAUS);
    Carta c7E = new Carta(ValorEnum.SETE,NaipeEnum.ESPADAS);
    Carta c7O = new Carta(ValorEnum.SETE,NaipeEnum.OUROS);

    Carta c8C = new Carta(ValorEnum.OITO,NaipeEnum.COPAS);
    Carta c8P = new Carta(ValorEnum.OITO,NaipeEnum.PAUS);
    Carta c8E = new Carta(ValorEnum.OITO,NaipeEnum.ESPADAS);
    Carta c8O = new Carta(ValorEnum.OITO,NaipeEnum.OUROS);

    Carta c2P = new Carta(ValorEnum.DOIS,NaipeEnum.PAUS);
    Carta c3C = new Carta(ValorEnum.TRES,NaipeEnum.COPAS);
    Carta c5E = new Carta(ValorEnum.CINCO,NaipeEnum.ESPADAS);
    Carta c9C = new Carta(ValorEnum.NOVE,NaipeEnum.COPAS);
    Carta cKO = new Carta(ValorEnum.REI,NaipeEnum.OUROS);

    Carta c2C = new Carta(ValorEnum.DOIS,NaipeEnum.COPAS);
    Carta c3P = new Carta(ValorEnum.TRES,NaipeEnum.PAUS);
    Carta cAO = new Carta(ValorEnum.AS,NaipeEnum.OUROS);

    Carta c2O = new Carta(ValorEnum.DOIS,NaipeEnum.OUROS);
    Carta c4E = new Carta(ValorEnum.QUATRO,NaipeEnum.ESPADAS);
    Carta c4C = new Carta(ValorEnum.QUATRO,NaipeEnum.COPAS);
    Carta c2E = new Carta(ValorEnum.DOIS,NaipeEnum.ESPADAS);
    Carta cAE = new Carta(ValorEnum.AS,NaipeEnum.ESPADAS);
    Carta cQE = new Carta(ValorEnum.DAMA,NaipeEnum.ESPADAS);
    Carta c3E = new Carta(ValorEnum.TRES,NaipeEnum.ESPADAS);

    /**
     * testa obtenção de cartas do baralho
     *
     */
    public void testPegarCartas() throws Exception {

        Baralho baralho = new Baralho();
        baralho.embaralha();

        Mao mao = new Mao(baralho);
        mao.pegaCartas();
        assertEquals(5, mao.cartas.size());
    }

    /**
     * testa atribuição de ranking das mãos
     *
     */
    public void testGetRanking() throws Exception {

        Baralho baralho = new Baralho();
        Mao mao = new Mao(baralho);

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c9P, c10P, cVP, cDP, c8P)));
        assertEquals(RankingEnum.STRAIGHT_FLUSH, mao.getRanking());
        assertEquals(cDP.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c8E, c8O, cDE)));
        assertEquals(RankingEnum.FOUR_OF_A_KIND, mao.getRanking());
        assertEquals(c8C.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c8E, cDE, cDP)));
        assertEquals(RankingEnum.FULL_HOUSE, mao.getRanking());
        assertEquals(c8C.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c8E, c7C, c7E)));
        assertEquals(RankingEnum.FULL_HOUSE, mao.getRanking());
        assertEquals(c8C.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(cAP, c5P, c7P, c9P, cVP)));
        assertEquals(RankingEnum.FLUSH, mao.getRanking());
        assertEquals(cAP.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c9P, c10P, cVO, cDE, c8C)));
        assertEquals(RankingEnum.STRAIGHT, mao.getRanking());
        assertEquals(cDE.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c8E, cDE, cVP)));
        assertEquals(RankingEnum.THREE_OF_A_KIND, mao.getRanking());
        assertEquals(c8P.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c7E, c7O, c10P)));
        assertEquals(RankingEnum.TWO_PAIRS, mao.getRanking());
        assertEquals(c8P.getValor() , mao.cartasRank.get(0).getValor()); //maior par
        assertEquals(c7E.getValor() , mao.cartasRank.get(1).getValor()); //menor par
        assertEquals(c10P.getValor() , mao.cartasRank.get(2).getValor()); //restante

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c7E, c7O, c5E)));
        assertEquals(RankingEnum.TWO_PAIRS, mao.getRanking());
        assertEquals(c8P.getValor() , mao.cartasRank.get(0).getValor()); //maior par
        assertEquals(c7E.getValor() , mao.cartasRank.get(1).getValor()); //menor par
        assertEquals(c5E.getValor() , mao.cartasRank.get(2).getValor()); //restante

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c2C, c2P, c7C)));
        assertEquals(RankingEnum.TWO_PAIRS, mao.getRanking());
        assertEquals(c8P.getValor() , mao.cartasRank.get(0).getValor()); //maior par
        assertEquals(c2C.getValor() , mao.cartasRank.get(1).getValor()); //menor par
        assertEquals(c7C.getValor() , mao.cartasRank.get(2).getValor()); //restante

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, cAP, c7O, c10P)));
        assertEquals(RankingEnum.PAIRS, mao.getRanking());
        assertEquals(c8P.getValor() , mao.cartasRank.get(0).getValor()); //par
        assertEquals(cAP.getValor() , mao.cartasRank.get(1).getValor()); //proxima
        assertEquals(c10P.getValor() , mao.cartasRank.get(2).getValor()); //proxima

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, cVO, cVP, c7O, c10P)));
        assertEquals(RankingEnum.PAIRS, mao.getRanking());
        assertEquals(cVO.getValor() , mao.cartasRank.get(0).getValor()); //par
        assertEquals(c10P.getValor() , mao.cartasRank.get(1).getValor()); //proxima
        assertEquals(c8C.getValor() , mao.cartasRank.get(2).getValor()); //proxima

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(cAP, cVO, c7C, c8C, c10P)));
        assertEquals(RankingEnum.HIGH_CARD, mao.getRanking());
        assertEquals(cAP.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor
        assertEquals(cVO.getValor() , mao.cartasRank.get(1).getValor()); //proxima
        assertEquals(c10P.getValor() , mao.cartasRank.get(2).getValor()); //proxima

        mao.setCartas(new ArrayList<Carta>(Arrays.asList(c2P, c3C, c5E, c9C, cKO)));
        assertEquals(RankingEnum.HIGH_CARD, mao.getRanking());
        assertEquals(cKO.getValor() , mao.cartasRank.get(0).getValor()); //carta de maior valor
        assertEquals(c9C.getValor() , mao.cartasRank.get(1).getValor()); //proxima
        assertEquals(c5E.getValor() , mao.cartasRank.get(2).getValor()); //proxima

    }

    /**
     * testa comparação entre mãos
     *
     */
    public void testCompare() throws Exception {
        Baralho baralho = new Baralho();
        Mao black = new Mao(baralho);
        Mao white = new Mao(baralho);

        black.setCartas(new ArrayList<Carta>(Arrays.asList(c9P, c10P, cVP, cDP, c8P)));
        white.setCartas(new ArrayList<Carta>(Arrays.asList(c8C, c8P, c7E, c7O, c10P)));
        assertTrue(black.compareTo(white) > 0);

        black.setCartas(new ArrayList<Carta>(Arrays.asList(c2P, c3C, c5E, c9C, cKO)));
        white.setCartas(new ArrayList<Carta>(Arrays.asList(c2C, c3P, c4E, c8C, cAO)));
        System.out.println("Entrada: Black: " + black.cartas + " White: " + white.cartas);
        saida(black, white);
        assertTrue(black.compareTo(white) > 0);


        black.setCartas(new ArrayList<Carta>(Arrays.asList(c2O, c4E, c4C, c2P, c4C)));
        white.setCartas(new ArrayList<Carta>(Arrays.asList(c2E, c8E, cAE, cQE, c3E)));
        System.out.println("Entrada: Black: " + black.cartas + " White: " + white.cartas);
        saida(black, white);
        assertTrue(black.compareTo(white) > 0);




    }

    public void saida(Mao black ,Mao white){
        if (black.compareTo(white) < 0) {
            System.out.println("Saida: White wins "+white.getRanking() + " : " + white.cartasRank.get(0));
        }else if (black.compareTo(white) > 0){
            System.out.println("Saida: Black wins "+black.getRanking() + " : " + white.cartasRank.get(0));
        }else{
            System.out.println("Saida: Tie");
        }
    }
}