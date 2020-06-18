package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Truck extends Item {
    int x;
    int y;



    public Truck() {
        super("Truck", 5000);
        this.x = 1050;
        this.y = 450;
        this.shape.setX(this.x);
        this.shape.setY(this.y);
        this.shape.setWidth(100);
        this.shape.setHeight(170);
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


}
