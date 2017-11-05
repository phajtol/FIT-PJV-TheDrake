package ceckari.thedrake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlacingLeadersGameState extends BaseGameState {
	
	public PlacingLeadersGameState(TroopStacks troopStacks, Tile... tiles) {
		super(
				new Board(4, tiles), 
				troopStacks,
				new NoLeadersPlaced(),						
				PlayingSide.BLUE); 
	}
	
	public PlacingLeadersGameState(Board board, TroopStacks troopStacks, Leaders leaders) {
		super(board, troopStacks, leaders, PlayingSide.ORANGE); 
	}
	
	public PlacingLeadersGameState placeBlueLeader(TilePosition blueLeaderPosition) {
		return new PlacingLeadersGameState(
				board().withTiles(
						new TroopTile(
								blueLeaderPosition, 
								troopStacks().peek(PlayingSide.BLUE))), 
				troopStacks().pop(PlayingSide.BLUE),
				new OneLeaderPlaced(PlayingSide.BLUE, blueLeaderPosition));
	}
	
	public PlacingGuardsGameState placeOrangeLeader(TilePosition orangeLeaderPosition) {
		return new PlacingGuardsGameState(
				board().withTiles(
						new TroopTile(
								orangeLeaderPosition, 
								troopStacks().peek(PlayingSide.ORANGE))),
				troopStacks().pop(PlayingSide.ORANGE),
				new BothLeadersPlaced(
						leaders().position(PlayingSide.BLUE), 
						orangeLeaderPosition),	
				PlayingSide.BLUE,
				0);
	}
	
	@Override
	public List<Move> allMoves() {
		return stackMoves();
	}
	
	@Override
	public List<Move> boardMoves(TilePosition position) {
		return Collections.emptyList();
	}
	
	@Override
	public List<Move> stackMoves() {		
		int row = sideOnTurn() == PlayingSide.BLUE ? 1 : 4;
		
		List<Move> result = new ArrayList<Move>();
		Troop leader = troopStacks().peek(sideOnTurn());
		for(char col = 'a'; col <= 'd'; col++) {
			TilePosition pos = new TilePosition(col, row);
			if(board().tileAt(pos).acceptsTroop(leader)) {
				result.add(new PlaceLeader(this, pos));
			}
		}

		return result;		
	}
	
	@Override
	public boolean isVictory() {
		return false;
	}
}
