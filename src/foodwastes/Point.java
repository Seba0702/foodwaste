package foodwastes;

public class Point {

    private double index = 0;
    
    public Point() {

    }

    public Point(double index) {
        this.index = index;

    }

    public void setPointPlusOne() {

        this.index += 1;

    }
    
    public void setMinusPoint(double point)
    {
        this.index = index - point;
    }
    
    public void setPlusPoint(double point)
    {
        this.index = index + point;
    }

    public void setPointMinusOne(double index) {

        this.index = index -= 1;

    }

    public double getPoint() {
        return this.index += 1;
    }

}
