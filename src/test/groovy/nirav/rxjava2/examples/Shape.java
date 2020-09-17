package nirav.rxjava2.examples;

public class Shape {
    private String shape;
    private String color;

    public Shape(String shape, String color) {
        this.shape = shape;
        this.color = color;
    }


    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "shape='" + shape + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
