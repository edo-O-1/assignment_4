
import static org.junit.Assert.*;
import org.junit.*;
public class PlotTestStudent {

    @Test
    public void testPlot() {                   
        Plot p = new Plot();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        assertEquals(1, p.getWidth());
        assertEquals(1, p.getDepth());
    }

    @Test
    public void testPlotIntIntIntInt() {      
        Plot p = new Plot(2, 3, 4, 5);
        assertEquals(2, p.getX());
        assertEquals(3, p.getY());
        assertEquals(4, p.getWidth());
        assertEquals(5, p.getDepth());
    }

    @Test
    public void testPlotPlot() {             
        Plot original = new Plot(1, 2, 3, 4);
        Plot copy     = new Plot(original);
        assertEquals("1,2,3,4", copy.toString());
        assertNotSame(original, copy);
    }

    @Test
    public void testGetX()   { assertEquals(5, new Plot(5,0,1,1).getX()); }

    @Test
    public void testGetY()   { assertEquals(6, new Plot(0,6,1,1).getY()); }

    @Test
    public void testGetWidth() { assertEquals(7, new Plot(0,0,7,1).getWidth()); }

    @Test
    public void testGetDepth() { assertEquals(8, new Plot(0,0,1,8).getDepth()); }

    @Test
    public void testSetX()   {
        Plot p = new Plot();
        p.setX(9);
        assertEquals(9, p.getX());
    }

    @Test
    public void testSetY()   {
        Plot p = new Plot();
        p.setY(10);
        assertEquals(10, p.getY());
    }

    @Test
    public void testSetWidth() {
        Plot p = new Plot();
        p.setWidth(11);
        assertEquals(11, p.getWidth());
    }

    @Test
    public void testSetDepth() {
        Plot p = new Plot();
        p.setDepth(12);
        assertEquals(12, p.getDepth());
    }

    @Test
    public void testOverlaps() {
        Plot a = new Plot(0, 0, 4, 4);
        Plot b = new Plot(2, 2, 4, 4); 
        Plot c = new Plot(4, 0, 2, 2);   
        assertTrue(a.overlaps(b));
        assertFalse(a.overlaps(c));
    }

    @Test
    public void testEncompasses() {
        Plot outer = new Plot(0, 0, 10, 10);
        Plot inner = new Plot(3, 3, 2, 2);
        Plot edge  = new Plot(0, 0, 10, 10); 
        assertTrue(outer.encompasses(inner));
        assertTrue(outer.encompasses(edge));
    }


    @Test
    public void testToString() {
        Plot p = new Plot(1, 2, 3, 4);
        assertEquals("1,2,3,4", p.toString());
    }
}