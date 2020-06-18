package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Container extends Item {
    private Rectangle shape ;
    private int X;
    private int Y;


    public Container(String name,int x , int y) {
        super(name, 3000);
        this.X = x;
        this.Y = y;
        this.shape = new Rectangle(x,y,140,200);
        this.shape.setFill(Color.DARKSEAGREEN);
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
    }
}
