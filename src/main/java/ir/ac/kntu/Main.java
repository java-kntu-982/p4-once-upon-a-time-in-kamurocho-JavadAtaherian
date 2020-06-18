package ir.ac.kntu;

import ir.ac.kntu.Database.Database;
import ir.ac.kntu.Database.RandomHelper;
import ir.ac.kntu.Game.Graphics;
import ir.ac.kntu.Game.InitializingEnemies;
import ir.ac.kntu.Item.Item;
import ir.ac.kntu.Item.Items.InitializingItems;
import ir.ac.kntu.Menu.MainMenu;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        Database.addTheFreeMercenary();
        Database.set500ToWallet();
        InitializingItems.createItems();
        InitializingEnemies.createEnemies();
//        Graphics.main(args);
        MainMenu.main(args);

    }



}

