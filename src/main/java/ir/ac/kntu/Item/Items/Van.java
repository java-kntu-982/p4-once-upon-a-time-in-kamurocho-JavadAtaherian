package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Van extends Item {
    private int x;
    private int y;
    Rectangle shape ;


    public Van(String name , int x , int y) {
        super(name, 6000);
        this.x = x;
        this.y = y;
        this.shape = new Rectangle(x,y,100,200);
        this.shape.setFill(Color.DARKORANGE);

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