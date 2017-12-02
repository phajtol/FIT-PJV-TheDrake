package ceckari.thedrake.game;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author friedtad
 */
public class StartMenuController implements Initializable {

    @FXML private Button endButton;
    @FXML private AnchorPane root;
    @FXML private Button networkGameButton;
    @FXML private Button multiplayerButton;
    @FXML private Button singleplayerButton;
    @FXML private Label ceckariLabel;
    @FXML private ImageView drakelogo;
    
    //true if currently shown logo is inverted (flags on opposite sides as usually)
    private boolean invertedLogo = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        endButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.exit(0);
            }
        });
        
        ceckariLabel.setOnMouseReleased(new EventHandler(){
            @Override
            public void handle(Event event) {
                drakelogo.setImage(new Image(getClass().getResource(invertedLogo?"assets/drake-logo.png":"assets/drake-logo_inv.png").toExternalForm()));
                invertedLogo = !invertedLogo;
            }
        });
    }

    /*
    public void endButtonPress(ActionEvent event){
        //System.out.println("x");
        System.exit(0);
    }*/
}
