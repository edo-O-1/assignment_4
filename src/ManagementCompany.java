

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


public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    private String name;
    private String taxID;
    private double mgmtFeePercentage;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;
    public ManagementCompany() {
        this("", "", 0);
    }
    
    public ManagementCompany(String name, String taxID, double mgmtFeePercentage) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFeePercentage = mgmtFeePercentage;
        // Initialize the management company's plot with default values (x=0, y=0, width=MGMT_WIDTH, depth=MGMT_DEPTH)
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }
    
    public ManagementCompany(String name, String taxID, double mgmtFeePercentage, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFeePercentage = mgmtFeePercentage;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getTaxID() {
        return taxID;
    }
    
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }
    
    public double getMgmtFeePercentage() {
        return mgmtFeePercentage;
    }
    
    public void setMgmtFeePercentage(double mgmtFeePercentage) {
        this.mgmtFeePercentage = mgmtFeePercentage;
    }
    
    public Plot getPlot() {
        return new Plot(plot);
    }
    
    public void setPlot(Plot plot) {
        this.plot = new Plot(plot);
    }
    
    public int getPropertiesCount() {
        return numberOfProperties;
    }
    
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }
    
    public boolean isManagementFeeValid() {
        return (mgmtFeePercentage >= 0 && mgmtFeePercentage <= 100);
    }
    
    public int addProperty(Property property) {
        if (property == null) {
            return -2;
        }
        if (isPropertiesFull()) {
            return -1;
        }
        if (!this.plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties[numberOfProperties] = new Property(property);
        return numberOfProperties++;
    }
    public int addProperty(String propertyName, String city, double rentalAmount, String owner) {
        Property prop = new Property(propertyName, city, rentalAmount, owner, new Plot(0, 0, 1, 1));
        return addProperty(prop);
    }
        public int addProperty(String propertyName, String city, double rentalAmount, String owner,
                           int x, int y, int width, int depth) {
        Property prop = new Property(propertyName, city, rentalAmount, owner, new Plot(x, y, width, depth));
        return addProperty(prop);
    }
    
    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                total += properties[i].getRentalAmount();
            }
        }
        return total;
    }
    
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getRentalAmount() > highest.getRentalAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }
    
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", TaxID: ").append(taxID)
          .append("\n--------------------------------------------------\n");
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                sb.append(properties[i].toString());
                sb.append("\n");
            }
        }
        sb.append("--------------------------------------------------\n");
        sb.append("Total management Fee: ").append((getTotalRent() * mgmtFeePercentage) / 100);
        return sb.toString();
    }
}