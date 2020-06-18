

//**********************done*******************//


package ir.ac.kntu.Menu;

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

public class CreditMenu extends Application {
    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(1280, 768);

        try(InputStream is = Files.newInputStream(Paths.get("./Pictures/img4.jpg"))){
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(1280);
            img.setFitHeight(768);
            root.getChildren().add(img);
        }
        catch(IOException e) {
            System.out.println("Couldn't load image");
        }

        CreditMenu.Title title = new CreditMenu.Title("C R E D I T" , 562 , 90 , 75);
        title.setTranslateX(360);
        title.setTranslateY(250);

        CreditMenu.Title title2 = new CreditMenu.Title("A production of Hideo Ataherian ;))" , 800, 72 , 50);
        title2.setTranslateX(250);
        title2.setTranslateY(600);

        CreditMenu.Title title3 = new CreditMenu.Title("@ all rights reserved :))" , 500 , 80 , 50);
        title3.setTranslateX(390);
        title3.setTranslateY(685);


        root.getChildren().addAll(title,title2,title3);

        return root;

    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("once upon a time in kamurocho  (CREDIT)");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static class Title extends StackPane {
        public Title(String name , int v1 , int v2 , int fontsize) {

            LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[]{
                    new Stop(0, Color.DARKRED),
                    new Stop(0.1, Color.BLACK),
                    new Stop(0.9, Color.BLACK),
                    new Stop(1, Color.DARKRED)

            });

            Rectangle bg = new Rectangle(v1, v2);
            bg.setStroke(Color.WHITE);
            bg.setStrokeWidth(2);
            bg.setFill(null);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, fontsize));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg,text);

            setOnMouseEntered(event ->{
                    bg.setFill(gradient);
                    text.setFill(Color.RED);
            });

            setOnMouseExited(event -> {
                    bg.setFill(null);
                    text.setFill(Color.WHITE);
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





    }













