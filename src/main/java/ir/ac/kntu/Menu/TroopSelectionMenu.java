package ir.ac.kntu.Menu;

import ir.ac.kntu.Database.Database;
import ir.ac.kntu.Game.Graphics;
import ir.ac.kntu.solider.Mercenaies;
import ir.ac.kntu.solider.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TroopSelectionMenu  extends Application {
    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(1280, 768);

        try (InputStream is = Files.newInputStream(Paths.get("./Pictures/img2.jpg"))) {
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(1280);
            img.setFitHeight(768);
            root.getChildren().add(img);
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }

        TroopSelectionMenu.Title title = new TroopSelectionMenu.Title("Choose your Army (10 mercenaries)" , 750 , 60);
        title.setTranslateX(225);
        title.setTranslateY(50);

        TroopSelectionMenu.Title title4 = new TroopSelectionMenu.Title("B A C K" , 250 , 60);
        title4.setTranslateX(452);
        title4.setTranslateY(700);


        TroopSelectionMenu.Title title3 = new TroopSelectionMenu.Title("AVAILABLE" , 550 , 70);
        title3.setTranslateX(365);
        title3.setTranslateY(140);

        TroopSelectionMenu.Title title5 = new TroopSelectionMenu.Title("Wallet =  " + Database.wallet.getMoney() , 300, 60);
        title5.setTranslateX(30);
        title5.setTranslateY(700);



        TroopSelectionMenu.MenuItem[] menuItems = new TroopSelectionMenu.MenuItem[Database.hiredMercenaries.size()];
        for (int i = 0; i < Database.hiredMercenaries.size() ; i++) {
            menuItems[i] = new TroopSelectionMenu.MenuItem(Database.hiredMercenaries.get(i));
        }


        TroopSelectionMenu.MenuBox vbox = new TroopSelectionMenu.MenuBox(menuItems);
        vbox.setTranslateX(420);
        vbox.setTranslateY(215);


        root.getChildren().addAll(title, title3 , title4, title5,  vbox);

        return root;

    }

    @Override
    public void start(Stage primaryStage2) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage2.setTitle("once upon a time in kamurocho (choosing troops)");
        primaryStage2.setScene(scene);
        primaryStage2.show();


    }

    private static class Title extends StackPane {
        public Title(String name , int width , int length) {

            LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[]{
                    new Stop(0, Color.DARKRED),
                    new Stop(0.1, Color.BLACK),
                    new Stop(0.9, Color.BLACK),
                    new Stop(1, Color.DARKRED)

            });

            Rectangle bg = new Rectangle(width, length);
            bg.setStroke(Color.DARKRED);
            bg.setStrokeWidth(2);
            bg.setFill(null);

            Text text = new Text(name);
            text.setFill(Color.BLACK);
            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);

            setOnMouseEntered( event -> {
                bg.setFill(gradient);
                text.setFill(Color.WHITE);
            });

            setOnMouseExited(event -> {
                bg.setFill(null);
                text.setFill(Color.BLACK);
            });

            setOnMouseClicked( event -> {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Platform.runLater(() -> {
                    try {

                        new MainMenu().start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            });


        }
    }

    private static class MenuBox extends VBox {
        public MenuBox(TroopSelectionMenu.MenuItem... items) {
            getChildren().add(createSeperator());

            for (TroopSelectionMenu.MenuItem item : items) {
                getChildren().addAll(item, createSeperator());
            }
        }

        private Line createSeperator() {
            Line sep = new Line();
            sep.setEndX(210);
            sep.setStroke(Color.DARKGREY);
            return sep;
        }

    }


    private static class MenuItem extends StackPane {
        public MenuItem(Mercenaies mercenary) {
            LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[]{
                    new Stop(0, Color.SILVER),
                    new Stop(0.1, Color.BLACK),
                    new Stop(0.9, Color.BLACK),
                    new Stop(1, Color.SILVER)

            });

            Rectangle bg = new Rectangle(450, 30);
            bg.setOpacity(0.4);

            Text text = new Text(mercenary.getName() + " | " + "attack= " + mercenary.getAttack() + " | " + "health" +mercenary.getHealth() + " | " + "$: " + mercenary.getPrice());
            text.setFill(Color.DARKGREY);
            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
            setOnMouseEntered(event -> {
                bg.setFill(gradient);
                text.setFill(Color.WHITE);

            });

            setOnMouseExited(event -> {
                bg.setFill(Color.BLACK);
                text.setFill(Color.DARKGREY);
            });
            setOnMousePressed(event -> {
                bg.setFill(Color.SNOW);

            });


            setOnMouseClicked(event -> {
                if (mercenary.isHired()==true){
                    Player player = new Player(mercenary);
                    Database.army.add(player);
                    System.out.println(player.toString());
                    if (Database.army.size()==10){
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        Platform.runLater(() -> {
                            try {

                                new Graphics().start(new Stage());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }


                }else{
                    System.out.println("you don't have this mercenary as a hired one  ");
                }

            });


        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
