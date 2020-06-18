package ir.ac.kntu.Menu;

import ir.ac.kntu.Database.Database;
import ir.ac.kntu.solider.Mercenaies;
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

public class StoreMenu extends Application {

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

        Title title = new Title("S T O R E" , 375 , 60);
        title.setTranslateX(452);
        title.setTranslateY(50);

        Title title4 = new Title("B A C K" , 250 , 60);
        title4.setTranslateX(452);
        title4.setTranslateY(700);

        Title title2 = new Title("HIRED MERCENARIES" , 550 , 70);
        title2.setTranslateX(80);
        title2.setTranslateY(140);

        Title title3 = new Title("AVAILABLE" , 550 , 70);
        title3.setTranslateX(640);
        title3.setTranslateY(140);

        Title title5 = new Title("Wallet =  " + Database.wallet.getMoney() , 300, 60);
        title5.setTranslateX(30);
        title5.setTranslateY(700);


        Database.updateHired();
        MenuItem[] menuItems = new MenuItem[Database.hiredMercenaries.size()];
        for (int i = 0; i < Database.hiredMercenaries.size() ; i++) {
            menuItems[i] = new MenuItem(Database.hiredMercenaries.get(i));
        }

        Database.updateAvailable();
        MenuItem[] menuItems2 = new MenuItem[Database.availableMercenaries.size()];
        for (int i = 0; i < Database.availableMercenaries.size() ; i++) {
            menuItems2[i] = new MenuItem(Database.availableMercenaries.get(i));
        }

        MenuBox vbox = new MenuBox(menuItems);
        vbox.setTranslateX(140);
        vbox.setTranslateY(215);

        MenuBox vbox2 = new MenuBox(menuItems2);
        vbox2.setTranslateX(700);
        vbox2.setTranslateY(215);


        root.getChildren().addAll(title, title2 , title3 , title4, title5,  vbox , vbox2);

        return root;

    }

    @Override
    public void start(Stage primaryStage2) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage2.setTitle("once upon a time in kamurocho (store)");
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
        public MenuBox(MenuItem... items) {
            getChildren().add(createSeperator());

            for (MenuItem item : items) {
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
               if (mercenary.isHired()==false && Database.wallet.getMoney()>= mercenary.getPrice()){
                   Database.hiredMercenaries.add(mercenary);
                   Database.wallet.setMoney(Database.wallet.getMoney()-mercenary.getPrice());

               }else if (Database.wallet.getMoney()<= mercenary.getPrice()){
                   System.out.println("you don't have enough money , you are broke dude :) ");
               }




            });


        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
