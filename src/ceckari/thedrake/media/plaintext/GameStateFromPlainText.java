package ceckari.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import ceckari.thedrake.game.Board;
import ceckari.thedrake.game.BothLeadersPlaced;
import ceckari.thedrake.game.GameState;
import ceckari.thedrake.game.Leaders;
import ceckari.thedrake.game.MiddleGameState;
import ceckari.thedrake.game.OneLeaderPlaced;
import ceckari.thedrake.game.PlacingGuardsGameState;
import ceckari.thedrake.game.PlacingLeadersGameState;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.TheDrakeSetup;
import ceckari.thedrake.game.TroopStacks;
import ceckari.thedrake.game.VictoryGameState;

public class GameStateFromPlainText {
	private final BufferedReader reader;
	private final TroopStacksFromPlainText stacksFromPlainText;
	private final LeadersFromPlainText leadersFromPlainText;
	private final BoardFromPlainText boardFromPlainText;
	
	public GameStateFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.reader = reader;
		this.stacksFromPlainText = new TroopStacksFromPlainText(setup, reader);
		this.leadersFromPlainText = new LeadersFromPlainText(setup, reader);
		this.boardFromPlainText = new BoardFromPlainText(setup, reader);
	}
	
	public GameState readGameState() throws IOException {
		String type = reader.readLine();
		int guards = Integer.parseInt(reader.readLine());
		PlayingSide sideOnTurn = PlayingSide.valueOf(reader.readLine());		 
		
		TroopStacks stacks = stacksFromPlainText.readTroopStacks();
		Leaders leaders = leadersFromPlainText.readLeaders();
		Board board = boardFromPlainText.readBoard();
		
		if("LEADERS".equals(type)) {
			return new PlacingLeadersGameState(board, stacks, leaders, sideOnTurn);
		} else if("GUARDS".equals(type)) {
			return new PlacingGuardsGameState(board, stacks, (BothLeadersPlaced)leaders, sideOnTurn, guards);
		} else if("MIDDLE".equals(type)) {
			return new MiddleGameState(board, stacks, (BothLeadersPlaced)leaders, sideOnTurn);
		} else if("VICTORY".equals(type)) {
			return new VictoryGameState(board, stacks, (OneLeaderPlaced)leaders, sideOnTurn);
		}
		
		throw new IOException("Invalid file format");
	}
}
