package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Container extends Item {
    private int x;
    private int y;


    public Container() {
        super("Container", 3000);
        this.x = 1050;
        this.y = 200;
        this.shape.setX(1050);
        this.shape.setY(100);
        this.shape.setWidth(140);
        this.shape.setHeight(200);
        this.shape.setFill(Color.DARKSEAGREEN);
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
