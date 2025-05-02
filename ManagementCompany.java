

/**Data Element class – Plot
Class: CMSC203
 Program: Assignment 4 Design
 Instructor: Gringberg
 Summary of Description: Data Element class – Plot
 Due Date 04/06/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: ozioma edokobi
 */

/**
 * Stores up to MAX_PROPERTY rental properties for one management company.
 * Business rules:
 *   • properties array size is fixed at MAX_PROPERTY (5)
 *   • each added property's plot must be inside the company plot
 *   • no two properties may overlap
 *   • management-fee percentage must be 0‒100
 */
public class ManagementCompany {


    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String  name      = "";
    private String  taxID     = "";
    private double  mgmFeePer = 0.0;

    private Plot plot;
    private Property[] properties = new Property[MAX_PROPERTY];
    private int numberOfProperties = 0;

    public ManagementCompany() {
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee,
                             int x, int y, int width, int depth) {
        this.name      = name;
        this.taxID     = taxID;
        this.mgmFeePer = mgmFee;
        this.plot      = new Plot(x, y, width, depth);
    }

    public ManagementCompany(ManagementCompany other) {
        this(other.name, other.taxID, other.mgmFeePer,
             other.plot.getX(), other.plot.getY(),
             other.plot.getWidth(), other.plot.getDepth());
        for (int i = 0; i < other.numberOfProperties; i++) {
            addProperty(other.properties[i]);   
        }
    }

    public int addProperty(String name, String city,
                           double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner,
                           int x, int y, int w, int d) {
        return addProperty(new Property(name, city, rent, owner, x, y, w, d));
    }

    public int addProperty(Property p) {
        if (isPropertiesFull())          return -1;  
        if (p == null)                   return -2; 
        if (!plot.encompasses(p.getPlot())) return -3;
        for (int i = 0; i < numberOfProperties; i++)
            if (properties[i].getPlot().overlaps(p.getPlot()))
                return -4;                   
        properties[numberOfProperties] = new Property(p); 
        return numberOfProperties++;                     
    }
    public void removeLastProperty() {
        if (numberOfProperties > 0)
            properties[--numberOfProperties] = null;
    }

    public boolean isPropertiesFull()    { return numberOfProperties == MAX_PROPERTY; }
    public int     getPropertiesCount()  { return numberOfProperties; }
    public boolean isMangementFeeValid() { return mgmFeePer >= 0 && mgmFeePer <= 100; }
    public double getTotalRent() {
        double sum = 0;
        for (int i = 0; i < numberOfProperties; i++)
            sum += properties[i].getRentAmount();
        return sum;
    }

    private int getHighestRentPropertyIndex() {
        if (numberOfProperties == 0) return -1;
        int hi = 0;
        for (int i = 1; i < numberOfProperties; i++)
            if (properties[i].getRentAmount() > properties[hi].getRentAmount())
                hi = i;
        return hi;
    }

    public Property getHighestRentProperty() {
        int idx = getHighestRentPropertyIndex();
        return idx == -1 ? null : properties[idx];
    }

    public String getName(){
    	return name; }
    public String getTaxID(){
    	return taxID; }
    public double getMgmFeePer(){ 
    	return mgmFeePer; }
    public Plot getPlot(){
    	return new Plot(plot); }
    public Property[] getProperties(){
    	return properties.clone(); 
    	}

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID).append('\n')
          .append("----------------------------------\n");
        for (int i = 0; i < numberOfProperties; i++)
            sb.append(properties[i]).append('\n');
        sb.append("----------------------------------\n");
        sb.append("total rent: ").append(getTotalRent());
        return sb.toString();
    }
}