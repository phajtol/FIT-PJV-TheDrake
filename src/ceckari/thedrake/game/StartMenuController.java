/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceckari.thedrake.game;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author friedtad
 */
public class StartMenuController implements Initializable{
  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void endButtonPress(ActionEvent event){
        System.exit(0);
    }
}
