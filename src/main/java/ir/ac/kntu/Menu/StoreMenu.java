/*TODO : create proper data structure for store and currency also make this a store ...*/
package ir.ac.kntu.Menu;

import javafx.application.Application;
import javafx.geometry.Pos;
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

        root.setPrefSize(1000, 600);

        try (InputStream is = Files.newInputStream(Paths.get("./Pictures/img3.jpg"))) {
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(1050);
            img.setFitHeight(600);
            root.getChildren().add(img);
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }

        Title title = new Title("Asian Union");
        title.setTranslateX(30);
        title.setTranslateY(300);

        MenuBox vbox = new MenuBox(
                new MenuItem("N E W   G A M E "),
                new MenuItem("J O I N   CO - OP"),
                new MenuItem("C R E D I T"));
        vbox.setTranslateX(105);
        vbox.setTranslateY(380);


        root.getChildren().addAll(title, vbox);

        return root;

    }

    @Override
    public void start(Stage primaryStage2) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage2.setTitle("once upon a time in kamurocho");
        primaryStage2.setScene(scene);
        primaryStage2.show();


    }

    private static class Title extends StackPane {
        public Title(String name) {
            Rectangle bg = new Rectangle(375, 60);
            bg.setStroke(Color.WHITE);
            bg.setStrokeWidth(2);
            bg.setFill(null);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
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
        public MenuItem(String name) {
            LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[]{
                    new Stop(0, Color.DARKBLUE),
                    new Stop(0.1, Color.BLACK),
                    new Stop(0.9, Color.BLACK),
                    new Stop(1, Color.DARKBLUE)

            });

            Rectangle bg = new Rectangle(200, 30);
            bg.setOpacity(0.4);

            Text text = new Text(name);
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
                if (name.equals("N E W   G A M E ")) {
                    System.out.println("dfghdkfjsdhf");

                }


            });


        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
