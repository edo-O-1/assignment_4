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


public class Property {
    private String propertyName;
    private String city;
    private double rentalAmount;
    private String owner;
    private Plot plot;
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentalAmount = 0;
        this.owner = "";
        this.plot = new Plot(0, 0, 1, 1);
    }
    public Property(String propertyName, String city, double rentalAmount, String owner, Plot plot) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        // Use Plot's copy constructor to avoid aliasing issues.
        this.plot = new Plot(plot);
    }
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentalAmount = otherProperty.rentalAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }
  
    public String getPropertyName() {
        return propertyName;
    }
  
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
  
    public String getCity() {
        return city;
    }
  
    public void setCity(String city) {
        this.city = city;
    }
  
    public double getRentalAmount() {
        return rentalAmount;
    }
  
    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }
  
    public String getOwner() {
        return owner;
    }
  
    public void setOwner(String owner) {
        this.owner = owner;
    }
  
    public Plot getPlot() {
        return new Plot(plot);
    }
  
    public void setPlot(Plot plot) {
        this.plot = new Plot(plot);
    }
  
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentalAmount;
    }
}