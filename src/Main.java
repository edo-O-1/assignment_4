
public class Main {
    public static void main(String[] args) {
        Plot managementPlot = new Plot(0, 0, 10, 10);
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10);

        Property p1 = new Property("Almost Aspen", "Glendale", 4844, "Sammy Smith", new Plot(1, 1, 2, 2));
        Property p2 = new Property("Ambiance", "Lakewood", 4114, "Tammy Taylor", new Plot(3, 3, 2, 2));
        Property p3 = new Property("Bear Creek Lodge", "Peninsula", 4905, "Bubba Burley", new Plot(5, 5, 2, 2));
        Property p4 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", new Plot(7, 7, 2, 2));
        Property p5 = new Property("Mystic Cove", "Lakepointe", 5327, "Joey BagODonuts", new Plot(8, 8, 2, 2));
        
        company.addProperty(p1);
        company.addProperty(p2);
        company.addProperty(p3);
        company.addProperty(p4);
        company.addProperty(p5);
        
        System.out.println(company);
    }
}