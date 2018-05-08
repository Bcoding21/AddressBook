package addressbooktests;
import addressbook.LastNameOrdered;
import addressbook.OrderFactory;
import addressbook.ZipOrdered;
import junit.framework.TestCase;
import org.junit.Test;

public class OrderFactoryTest extends TestCase{
    private OrderFactory factory;

    @Override
    protected void setUp(){
        factory = OrderFactory.getInstance();
    }

    @Test
    public void testGetInstance(){
        OrderFactory secondFactory = OrderFactory.getInstance();
        assertTrue(factory == secondFactory);
    }

    @Test
    public void testGetZipBased(){
        Object object = factory.getOrder("zip");
        assertTrue(object instanceof ZipOrdered);
    }

    @Test
    public void testGetLastNameBased(){
        Object object = factory.getOrder("lastname");
        assertTrue(object instanceof LastNameOrdered);
    }

    @Test
    public void testFactoryFail(){
        Object object = factory.getOrder("age");
        assertNull(object);
    }
}
