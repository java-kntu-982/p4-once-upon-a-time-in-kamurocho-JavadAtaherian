package ir.ac.kntu.solider;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.TriangleMesh;

public class Player {
    private Mercenaies player;
    private int currentX;
    private int currentY;
    private int currentHP;
    private int speed ;
    private Circle shape;
    private boolean isFighting;
    private boolean isAlive ;




    public Player(int index, int currentX, int currentY, int currentHP, int speed, boolean isFighting, boolean isAlive) {
        this.player = Mercenaies.byIndex(index);
        this.currentX = currentX;
        this.currentY = currentY;
        this.currentHP = player.getHealth();
        this.speed = 4;
        this.isFighting = false;
        this.isAlive = true;
        this.shape = new Circle();
        this.shape.setRadius(15);
        this.shape.setFill(Color.PURPLE);
    }

    public Mercenaies getPlayer() {
        return player;
    }

    public void setPlayer(Mercenaies player) {
        this.player = player;
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

    @Override
    public String toString() {
        return "Player{" +
                "player=" + player +
                ", currentX=" + currentX +
                ", currentY=" + currentY +
                ", currentHP=" + currentHP +
                ", speed=" + speed +
                ", isFighting=" + isFighting +
                ", isAlive=" + isAlive +
                '}';
    }
}
