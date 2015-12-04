package poker.model;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Teste do Baralho
 */
public class BaralhoTest extends TestCase {

    /**
     * testa geração do baralho
     *
     */
    public void testCriarBaralho() throws Exception {
        Baralho baralho = new Baralho();
        assertEquals(52,baralho.size());
        System.out.println(baralho.cartas);
    }

    /**
     * testa distribuição de cartas
     *
     */
    public void testDarCartas() throws Exception {
        Baralho baralho = new Baralho();
        baralho.embaralha();
        ArrayList<Carta> cartas = baralho.darCartas(5);
        assertEquals(5,cartas.size());
        assertEquals(47, baralho.size());
        System.out.println(cartas);
    }

}