package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SteelFramework extends Item {
    private Rectangle shape ;
    private int x;
    private int y;

    public SteelFramework(String name, int durability) {
        super(name, 8500);
        this.x = x;
        this.y = y;
        this.shape = new Rectangle(x,y,180,400);
        this.shape.setFill(Color.SILVER);
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
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
}
