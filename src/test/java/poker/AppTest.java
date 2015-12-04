package poker;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import poker.model.BaralhoTest;
import poker.model.MaoTest;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        TestSuite suite = new TestSuite("All Tests");
        suite.addTest(new TestSuite(BaralhoTest.class));
        suite.addTest(new TestSuite(MaoTest.class));

        return suite;
    }

}