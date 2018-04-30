package tests;
import addressbook.LastNameBased;
import addressbook.SortOrderFactory;
import addressbook.ZipBased;
import junit.framework.TestCase;
import org.junit.Test;

public class SortOrderFactoryTest extends TestCase{
    private SortOrderFactory factory;

    @Override
    protected void setUp(){
        factory = SortOrderFactory.getInstance();
    }

    @Test
    public void testGetInstance(){
        SortOrderFactory secondFactory = SortOrderFactory.getInstance();
        assertTrue(factory == secondFactory);
    }

    @Test
    public void testGetZipBased(){
        Object object = factory.getOrder("zip");
        assertTrue(object instanceof ZipBased);
    }

    @Test
    public void testGetLastNameBased(){
        Object object = factory.getOrder("lastname");
        assertTrue(object instanceof LastNameBased);
    }

    @Test
    public void testFactoryFail(){
        Object object = factory.getOrder("age");
        assertNull(object);
    }
}
