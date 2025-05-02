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

public class Plot {
    private int x;    
    private int y;    
    private int width;  
    private int depth;  


    public Plot() {
        this(0, 0, 1, 1);
    }


    public Plot(int x, int y, int width, int depth) {
        this.x      = x;
        this.y      = y;
        this.width  = width;
        this.depth  = depth;
    }


    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    public int getX()      { return x; }
    public int getY()      { return y; }
    public int getWidth()  { return width; }
    public int getDepth()  { return depth; }

    public void setX(int x)           { this.x = x; }
    public void setY(int y)           { this.y = y; }
    public void setWidth(int width)   { this.width = width; }
    public void setDepth(int depth)   { this.depth = depth; }


    /**

     * @param 
     * @return 
     */
    public boolean overlaps(Plot plot) {
        if (plot == null) return false;

        boolean separated =
                (x + width)  <= plot.x ||  
                (plot.x + plot.width) <= x   ||  
                (y + depth)  <= plot.y || 
                (plot.y + plot.depth) <= y;  

        return !separated;
    }

    /**
     * @param 
     * @return 
     */
    public boolean encompasses(Plot plot) {
        if (plot == null) return false;

        return  plot.x              >= this.x &&
                plot.y              >= this.y &&
                (plot.x + plot.width)  <= (this.x + this.width) &&
                (plot.y + plot.depth)  <= (this.y + this.depth);
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}