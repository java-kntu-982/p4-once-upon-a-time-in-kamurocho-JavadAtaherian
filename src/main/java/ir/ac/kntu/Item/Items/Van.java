package ir.ac.kntu.Item.Items;

import ir.ac.kntu.Item.Item;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Van extends Item {
    private int x;
    private int y;



    public Van() {
        super("Van", 6000);
        this.x = 1050;
        this.y = 500;
        this.shape.setX(this.x);
        this.shape.setY(this.y);
        this.shape.setWidth(100);
        this.shape.setHeight(200);
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


}