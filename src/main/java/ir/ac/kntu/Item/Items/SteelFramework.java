package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SteelFramework extends Item {
    private Rectangle shape ;
    private int x;
    private int y;

    public SteelFramework() {
        super("SteelFramework", 8500);
        this.x = 1000;
        this.y = 150;
        this.shape.setX(this.x);
        this.shape.setY(this.y);
        this.shape.setWidth(180);
        this.shape.setHeight(400);
        this.shape.setFill(Color.SILVER);
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
