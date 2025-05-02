

import static org.junit.Assert.*;
import org.junit.*;


public class ManagementCompanyTestStudent {

    private ManagementCompany mc;   

    @Before
    public void setUp() {
        mc = new ManagementCompany("ACME", "11-1111111", 8.0);
    }


    @Test
    public void testManagementCompany() {                 // no-arg
        ManagementCompany m = new ManagementCompany();
        assertEquals("", m.getName());
        assertEquals("", m.getTaxID());
        assertEquals(0.0, m.getMgmFeePer(), 0.001);
    }

    @Test
    public void testManagementCompanyString2() {
        ManagementCompany m = new ManagementCompany("Foobar", "55-5555", 12.5);
        assertEquals("Foobar",  m.getName());
        assertEquals("55-5555", m.getTaxID());
        assertEquals(12.5,      m.getMgmFeePer(), 0.001);
        // default plot 0,0 – 10×10
        assertEquals("0,0,10,10", m.getPlot().toString());
    }

    @Test
    public void testManagementCompanyString() {
        ManagementCompany m = new ManagementCompany("Foo", "77", 5,
                                                    5, 5, 20, 20);
        assertEquals("5,5,20,20", m.getPlot().toString());
    }

    @Test
    public void testManagementCompanyInt() {
        mc.addProperty("A", "X", 1000, "Bob");
        ManagementCompany copy = new ManagementCompany(mc);
        assertEquals(mc.getTotalRent(), copy.getTotalRent(), 0.001);
        assertNotSame(mc, copy);
    }

    @Test
    public void testAddPropertyString() {
        int idx = mc.addProperty("House", "Town", 1500, "Mary");
        assertEquals(0, idx);
        assertEquals(1, mc.getPropertiesCount());
    }

    @Test
    public void testAddProperty() {
        int idx = mc.addProperty("Villa", "City", 2500, "John",
                                 2, 2, 3, 3);
        assertEquals(0, idx);
        assertEquals(1, mc.getPropertiesCount());
        assertEquals("Villa", mc.getProperties()[0].getPropertyName());
    }

    @Test
    public void testAddPropertyProperty() {
        Property p = new Property("Loft", "Metro", 1800, "Sue",
                                  4, 4, 2, 2);
        int idx = mc.addProperty(p);
        assertEquals(0, idx);
        assertEquals("Loft", mc.getProperties()[idx].getPropertyName());
    }

    @Test
    public void testRemoveLastProperty() {
        mc.addProperty("X", "C", 800, "O", 1,1,2,2);
        mc.addProperty("Y", "C", 900, "O", 4,4,2,2);
        mc.removeLastProperty();
        assertEquals(1, mc.getPropertiesCount());
        assertEquals("X", mc.getProperties()[0].getPropertyName());
    }

    @Test
    public void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mc.addProperty("P"+i, "C", 100+i, "O", 0, i*2, 2, 2);
        }
        assertTrue(mc.isPropertiesFull());
        assertEquals(-1, mc.addProperty("Overflow", "C", 999, "O"));
    }

    @Test
    public void testGetPropertiesCount() {
        assertEquals(0, mc.getPropertiesCount());
        mc.addProperty("A", "X", 1000, "Bob");
        assertEquals(1, mc.getPropertiesCount());
    }

    @Test
    public void testIsMangementFeeValid() {
        assertTrue(mc.isMangementFeeValid());
        ManagementCompany bad = new ManagementCompany("Bad", "22", 150);
        assertFalse(bad.isMangementFeeValid());
    }

    @Test
    public void testGetTotalRent() {
        mc.addProperty("L1", "A", 2000, "M", 1,1,2,2);
        mc.addProperty("L2", "B", 3000, "N", 4,4,2,2);
        assertEquals(5000.0, mc.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty() {
        mc.addProperty("Cheap",  "X", 1000, "A", 1,1,2,2);
        mc.addProperty("Expensive", "Y", 5000, "B", 4,4,2,2);
        assertEquals("Expensive",
                     mc.getHighestRentProperty().getPropertyName());
    }

    @Test
    public void testGetName(){
    	assertEquals("ACME", mc.getName()); }

    @Test
    public void testGetTaxID(){
    	assertEquals("11-1111111", mc.getTaxID()); }

    @Test
    public void testGetMgmFeePer(){
    	assertEquals(8.0, mc.getMgmFeePer(), 0.001); }

    @Test
    public void testGetPlot(){
    	assertEquals("0,0,10,10", mc.getPlot().toString()); }

    @Test
    public void testGetProperties() {
        mc.addProperty("Z", "C", 700, "O");  
        Property[] props = mc.getProperties();
        assertEquals(ManagementCompany.MAX_PROPERTY, props.length);
        assertNotNull(props[0]);
        assertEquals("Z", props[0].getPropertyName());
        for (int i = 1; i < props.length; i++) {
            assertNull(props[i]);
        }
        assertEquals(1, mc.getPropertiesCount());
    }

    @Test
    public void testToString() {
        mc.addProperty("Alpha", "X", 1000, "A");
        String s = mc.toString();
        assertTrue(s.contains("ACME"));
        assertTrue(s.contains("Alpha"));
        assertTrue(s.contains("total rent"));
    }
}