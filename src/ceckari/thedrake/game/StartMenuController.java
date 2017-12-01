
package ceckari.thedrake.game;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author friedtad
 */
public class StartMenuController implements Initializable{
    @FXML private Button endButton;
    @FXML private Pane pane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        endButton.setOnMouseReleased(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });
    }
    /*
    public void endButtonPress(ActionEvent event){
        //System.out.println("x");
        System.exit(0);
    }*/
}
