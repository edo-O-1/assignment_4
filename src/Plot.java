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
    private int plotNumber;
    private static int plotCount = 0;
    private static final int MAX_PLOT_NUMBER = 1000;
    private static final int MIN_PLOT_NUMBER = 1;
    private static final int MAX_WIDTH = 100;
    private static final int MIN_WIDTH = 1;
    public Plot(int x, int y, int width, int depth) {
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x > MAX_WIDTH) {
            x = MAX_WIDTH;
        }
        if (y > MAX_WIDTH) {
            y = MAX_WIDTH;
        }
        if (width < MIN_WIDTH) {
            width = MIN_WIDTH;
        }
        if (width > MAX_WIDTH) {
            width = MAX_WIDTH;
        }
        if (depth < MIN_WIDTH) {
            depth = MIN_WIDTH;
        }
        if (depth > MAX_WIDTH) {
            depth = MAX_WIDTH;
        }
        if (x + width > MAX_WIDTH) {
            width = MAX_WIDTH - x;
        }
        if (y + depth > MAX_WIDTH) {
            depth = MAX_WIDTH - y;
        }
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
        
        this.plotNumber = MIN_PLOT_NUMBER + plotCount;
        plotCount++;
        if (plotCount > MAX_PLOT_NUMBER) {
            plotCount = MIN_PLOT_NUMBER;
        }
    }
    
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
        this.plotNumber = otherPlot.plotNumber;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
      if (x < 0) {
          x = 0;
        }
       if (x > MAX_WIDTH) {
            x = MAX_WIDTH;
        }
       if (x + this.width > MAX_WIDTH) {
            this.width = MAX_WIDTH - x;
        }
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    public void setY(int y) {
      if (y < 0) {
          y = 0;
      }
      if (y > MAX_WIDTH) {
          y = MAX_WIDTH;
      }
      if (y + this.depth > MAX_WIDTH) {
          this.depth = MAX_WIDTH - y;
      }
      this.y = y;
  }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
      if (width < MIN_WIDTH) {
          width = MIN_WIDTH;
      }
      if (width > MAX_WIDTH) {
          width = MAX_WIDTH;
      }
      if (this.x + width > MAX_WIDTH) {
          width = MAX_WIDTH - this.x;
      }
      this.width = width;
  }
    
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        if (depth < MIN_WIDTH) {
            depth = MIN_WIDTH;
        }
        if (depth > MAX_WIDTH) {
            depth = MAX_WIDTH;
        }
        if (this.y + depth > MAX_WIDTH) {
            depth = MAX_WIDTH - this.y;
        }
        this.depth = depth;
    }
  
    public boolean overlaps(Plot plot) {
        if (this.x + this.width <= plot.x || plot.x + plot.width <= this.x) {
            return false;
        }
        if (this.y + this.depth <= plot.y || plot.y + plot.depth <= this.y) {
            return false;
        }
        return true;
    }
    
    public boolean encompasses(Plot plot) {
        return (plot.x >= this.x &&
                plot.y >= this.y &&
                plot.x + plot.width <= this.x + this.width &&
                plot.y + plot.depth <= this.y + this.depth);
    }
        public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}