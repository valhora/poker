package poker.model;

import junit.framework.TestCase;

public class MaoTest extends TestCase {

    public void testPegarCartas() throws Exception {

        Baralho baralho = new Baralho();
        baralho.embaralha();

        Mao mao = new Mao(baralho);
        mao.pegaCartas();
        assertEquals(5,mao.cartas.size());
        System.out.println(mao.cartas);
    }
}