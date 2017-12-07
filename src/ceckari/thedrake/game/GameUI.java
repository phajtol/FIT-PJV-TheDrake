package ceckari.thedrake.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GameUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        root.setId("pane");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("The Drake");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("assets/icon.png")));
        stage.show();
    }
    
}
