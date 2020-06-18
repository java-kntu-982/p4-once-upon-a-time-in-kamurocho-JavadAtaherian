package ir.ac.kntu.solider;

import ir.ac.kntu.Database.RandomHelper;
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
    boolean isAlive ;




    public Ai() {
        int rand = RandomHelper.nextInt(4);
        this.ai = Enemies.byIndex(rand);
        this.currentX = RandomHelper.nextInt(200)+30;
        this.currentY = RandomHelper.nextInt(600)+30;
        this.currentHP = this.ai.getHealth();
        if (rand==0){
            this.speed = 3;
        }
        if (rand==2){
            this.speed = 4;
        }else{
            this.speed = 2;
        }
        this.isFighting = false;
        this.shape = new Circle();
        this.shape.setRadius(10);
        this.shape.setFill(getColor());
        this.shape.setCenterX(this.currentX);
        this.shape.setCenterY(this.currentY);
        this.isAlive = true;

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Circle getShape() {
        return shape;
    }

    public void setShape(Circle shape) {
        this.shape = shape;
    }

    public void relocate (int x , int y){
        shape.setCenterX(x);
        shape.setCenterY(y);
        setCurrentX(x);
        setCurrentY(y);
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

    @Override
    public String toString() {
        return "Ai{" +
                "ai=" + ai.toString() +
                ", currentX=" + currentX +
                ", currentY=" + currentY +
                ", currentHP=" + currentHP +
                ", speed=" + speed +
                ", isFighting=" + isFighting +
                '}';
    }
}
