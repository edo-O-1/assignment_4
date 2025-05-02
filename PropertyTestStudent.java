
import static org.junit.Assert.*;
import org.junit.*;

public class PropertyTestStudent {

    @Test
    public void testProperty() {               
        Property p = new Property();
        assertEquals("",  p.getPropertyName());
        assertEquals("",  p.getCity());
        assertEquals("",  p.getOwner());
        assertEquals(0.0, p.getRentAmount(), 0.001);
        assertEquals("0,0,1,1", p.getPlot().toString());
    }

    @Test
    public void testPropertyStringStringDoubleString(){ 
        Property p = new Property("Bungalow", "Sacramento", 2500.0, "Zorg");
        assertEquals("Bungalow",  p.getPropertyName());
        assertEquals("Sacramento",p.getCity());
        assertEquals("Zorg",      p.getOwner());
        assertEquals(2500.0,      p.getRentAmount(), 0.001);
        assertEquals("0,0,1,1",   p.getPlot().toString());
    }

    @Test
    public void testPropertyStringStringDoubleStringIntIntIntInt(){ 
        Property p = new Property("Penthouse", "LosAngeles", 4800.0, "Nova",
                                   5, 6, 7, 8);
        assertEquals("5,6,7,8", p.getPlot().toString());
    }

    @Test
    public void testPropertyProperty(){   
        Property a = new Property("Cottage", "SanDiego", 1800.0, "Orion",
                                   1, 1, 2, 2);
        Property b = new Property(a);
        assertEquals(a.toString(), b.toString());
        assertNotSame(a, b);
        Plot bp = b.getPlot();
        bp.setX(99);
        assertNotEquals("99,1,2,2", a.getPlot().toString());
    }

    private final Property sample =
        new Property("Ranch", "SanJose", 3200.0, "Andromeda", 2, 2, 3, 3);

    @Test public void testGetPropertyName() { assertEquals("Ranch",     sample.getPropertyName()); }
    @Test public void testGetCity()         { assertEquals("SanJose",   sample.getCity()); }
    @Test public void testGetRentAmount()   { assertEquals(3200.0, sample.getRentAmount(), 0.001); }
    @Test public void testGetOwner()        { assertEquals("Andromeda", sample.getOwner()); }

    @Test
    public void testGetPlot() {
        Plot pl = sample.getPlot();
        assertEquals("2,2,3,3", pl.toString());
        pl.setX(88);                         
        assertEquals("2,2,3,3", sample.getPlot().toString());
    }

    @Test
    public void testToString() {
        Property p = new Property("Villa", "SanFrancisco", 5400.0, "Vega");
        assertEquals("Villa,SanFrancisco,Vega,5400.0", p.toString());
    }
}