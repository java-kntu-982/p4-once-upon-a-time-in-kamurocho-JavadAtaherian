package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Truck extends Item {
    int x;
    int y;
    Rectangle shape ;


    public Truck(String name, int x , int y) {
        super(name, 5000);
        this.x = x;
        this.y = y;
        this.shape = new Rectangle(x,y,100,170);
        this.shape.setFill(Color.DARKGRAY);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
    }
}
