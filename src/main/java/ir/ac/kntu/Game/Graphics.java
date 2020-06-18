package ir.ac.kntu.Game;

import ir.ac.kntu.Database.Database;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Graphics extends Application{


    private Parent createContent(){
        Group root = new Group();


        for (int i = 0; i < Database.army.size(); i++) {
            root.getChildren().add(Database.army.get(i).getShape());
        }

        for (int i = 0; i < Database.enemyArmy.size(); i++) {
            root.getChildren().add(Database.enemyArmy.get(i).getShape());
        }

        for (int i = 0; i < Database.items.size(); i++) {
            root.getChildren().add(Database.items.get(i).getShape());
        }





        return root;
    }


    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(createContent());
        stage.setTitle("new game");
        stage.setScene(scene);
        stage.show();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                GamePlay.moveEnemy();

            }
        } , 40, 40);




    }


    public static void main(String[] args) {
        launch(args);


    }
}
