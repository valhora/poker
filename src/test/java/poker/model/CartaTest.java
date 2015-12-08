package poker.model;

import junit.framework.TestCase;

import java.util.Collections;


public class CartaTest extends TestCase {

    /**
     *
     * testa comparação entre cartas
     */
    public void testCompareTo() throws Exception {
        Carta carta1 = new Carta(ValorEnum.DEZ,NaipeEnum.OUROS);
        Carta carta2 = new Carta(ValorEnum.CINCO,NaipeEnum.OUROS);
        Carta carta3 = new Carta(ValorEnum.DEZ,NaipeEnum.OUROS);

        assertEquals(0,carta1.compareTo(carta3));
        assertEquals(-1, carta1.compareTo(carta2));
        assertEquals(1, carta2.compareTo(carta1));
    }
}