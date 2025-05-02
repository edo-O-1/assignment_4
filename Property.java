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
    private double rentAmount;
    private String owner;
    private Plot plot;      


    public Property() {
        this("", "", 0.0, "", new Plot());
    }

    public Property(String propertyName, String city,
                    double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, new Plot());
    }

    public Property(String propertyName, String city,
                    double rentAmount, String owner,
                    int x, int y, int width, int depth) {
        this(propertyName, city, rentAmount, owner,
             new Plot(x, y, width, depth));
    }

    private Property(String propertyName, String city,
                     double rentAmount, String owner, Plot plot) {
        this.propertyName = propertyName;
        this.city         = city;
        this.rentAmount   = rentAmount;
        this.owner        = owner;
        this.plot         = new Plot(plot);     
    }

    public Property(Property otherProperty) {
        this(otherProperty.propertyName,
             otherProperty.city,
             otherProperty.rentAmount,
             otherProperty.owner,
             otherProperty.plot);
    }

    public String getPropertyName()
    { return propertyName; 
    }
    public String getCity()
    { return city; }
    public double getRentAmount()
    { return rentAmount; }
    public String getOwner()
    { return owner; }
    public Plot   getPlot()
    { return new Plot(plot); 
    }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}