package ceckari.thedrake.ui;

import ceckari.thedrake.game.BasicTroopStacks;
import ceckari.thedrake.game.Board;
import ceckari.thedrake.game.BothLeadersPlaced;
import ceckari.thedrake.game.CapturedTroops;
import ceckari.thedrake.game.GameState;
import ceckari.thedrake.game.MiddleGameState;
import ceckari.thedrake.game.NoLeadersPlaced;
import ceckari.thedrake.game.PlacingLeadersGameState;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.StandardDrakeSetup;
import ceckari.thedrake.game.TilePosition;
import ceckari.thedrake.game.Troop;
import ceckari.thedrake.game.TroopFace;
import ceckari.thedrake.game.TroopTile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TheDrakeApplication extends Application {
    
   
    protected Label bottomLabel;
    
    protected void setLabelText(String text){
        bottomLabel.setText(text);
    }
            
            
  public static void main(String[] args) {
	launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
	GameState state = createTestGame();
	
	BoardView boardView = new BoardView(state);
        BorderPane borderPane = new BorderPane();
        bottomLabel = new Label((state.sideOnTurn() == PlayingSide.BLUE ? "Modrý" : "Oranžový") + " je na ťahu.");
        
        borderPane.setTop(new ImageView(new Image(getClass().getResource("assets/drake-logo.png").toExternalForm()) ));
        borderPane.setCenter(boardView);
        borderPane.setBottom(bottomLabel);
        
	Scene scene = new Scene(borderPane);
        
        
        
	stage.setScene(scene);
	stage.setTitle("The Drake");
	stage.show();
  }

  private Board createTestBoard() {
	StandardDrakeSetup setup = new StandardDrakeSetup();
	Board board = new Board(
			4,
			new CapturedTroops() ,
			new TroopTile(new TilePosition("a1"), new Troop(setup.MONK, PlayingSide.BLUE)),
			new TroopTile(new TilePosition("b1"), new Troop(setup.DRAKE, PlayingSide.BLUE)),
			new TroopTile(new TilePosition("a2"), new Troop(setup.SPEARMAN, PlayingSide.BLUE)),
			new TroopTile(new TilePosition("c2"), new Troop(setup.CLUBMAN, PlayingSide.BLUE)),
			new TroopTile(new TilePosition("a4"), new Troop(setup.ARCHER, PlayingSide.ORANGE, TroopFace.BACK)),
			new TroopTile(new TilePosition("b4"), new Troop(setup.DRAKE, PlayingSide.ORANGE, TroopFace.BACK)),
			new TroopTile(new TilePosition("c3"), new Troop(setup.SWORDSMAN, PlayingSide.ORANGE))
        );
	return board;
  }

  private GameState createTestGame() {
	Board board = createTestBoard();
	StandardDrakeSetup setup = new StandardDrakeSetup();
	return new MiddleGameState(
			board,
			new BasicTroopStacks(setup.CLUBMAN),
			new BothLeadersPlaced(new TilePosition("b1"), new TilePosition("b4")),
			PlayingSide.BLUE);
    }
}
