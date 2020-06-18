package ir.ac.kntu.Item;

import javafx.scene.shape.Rectangle;

public class Item {
    private String name;
    private int durability;
    protected Rectangle shape ;

    public Item(String name , int durability) {
        this.name = name;
        this.durability = durability;
        this.shape = new Rectangle();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
    }

}
