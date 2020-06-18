package ir.ac.kntu.solider;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ai {
    private Enemies ai ;
    private int currentX;
    private int currentY;
    private int currentHP;
    private int speed;
    private Circle shape;
    boolean isFighting;




    public Ai(int index, int currentX, int currentY, int currentHP, int speed, boolean isFighting) {
        this.ai = Enemies.byIndex(index);
        this.currentX = currentX;
        this.currentY = currentY;
        this.currentHP = currentHP;
        this.speed = speed;
        this.isFighting = isFighting;
        this.shape = new Circle();
        this.shape.setRadius(10);
        this.shape.setFill(getColor());

    }

    public Enemies getAi() {
        return ai;
    }

    public void setAi(Enemies ai) {
        this.ai = ai;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public boolean isFighting() {
        return isFighting;
    }

    public void setFighting(boolean fighting) {
        isFighting = fighting;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    Paint getColor(){
        if (this.ai.getName().equalsIgnoreCase("red")) {
            return Color.RED;
        }
        if (this.ai.getName().equalsIgnoreCase("yellow")){
            return Color.YELLOW;
        }
        if (this.ai.getName().equalsIgnoreCase("gray")) {
            return Color.GRAY;
        }
        if (this.ai.getName().equalsIgnoreCase("green")){
            return Color.GREEN;
        }
        return Color.DARKRED;
    }
}
