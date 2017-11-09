package ceckari.thedrake.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MiddleGameState extends BaseGameState {
		
	public MiddleGameState(Board board, TroopStacks troopStacks, BothLeadersPlaced leaders, PlayingSide sideOnTurn) {
		super(board, troopStacks, leaders, sideOnTurn);
	}


	@Override
	public BothLeadersPlaced leaders() {
		return (BothLeadersPlaced)super.leaders();
	}


	@Override
	public List<Move> allMoves() {
		List<Move> result = new ArrayList<Move>();

		result.addAll(stackMoves());

		for(Tile t : board())
		    if(t.hasTroop() && t.troop().side() == sideOnTurn())
		        result.addAll(boardMoves(t.position()));

        return result;
	}	


	@Override
	public List<Move> boardMoves(TilePosition position) {
        if(!board().tileAt(position).hasTroop() || board().tileAt(position).troop().side() != sideOnTurn()) return Collections.emptyList();

        List<BoardChange> changesFrom = board().tileAt(position).troop().changesFrom(position,board());
        List<Move> result = new ArrayList<Move>();
        for(BoardChange b : changesFrom)
            result.add(new BoardMove(this,b));

        return result;
	}


	@Override
	public List<Move> stackMoves() {
        List<Move> result = new ArrayList<>();

        for(Tile tile : board())
            if(canPlaceFromStack(tile.position()))
                result.add(new PlaceFromStack(this, tile.position()));

        return result;
	}


	@Override
	public boolean isVictory() {
		return false;
	}


	public boolean canPlaceFromStack(TilePosition target) {
		if(!super.board().canPlaceTo(troopStacks().peek(sideOnTurn()), target)) return false;

		boolean canPlaceFromStack = false;
		canPlaceFromStack |= isNeighborSameSide(target, new Offset2D(1,0));
        canPlaceFromStack |= isNeighborSameSide(target, new Offset2D(0,1));
        canPlaceFromStack |= isNeighborSameSide(target, new Offset2D(-1,0));
        canPlaceFromStack |= isNeighborSameSide(target, new Offset2D(0,-1));

        return canPlaceFromStack;
	}


	public MiddleGameState placeFromStack(TilePosition target) {
		Troop troop = troopStacks().peek(sideOnTurn());
		return new MiddleGameState(
				board().withTiles(  
					new TroopTile(target, troop)),  
				troopStacks().pop(sideOnTurn()),
				leaders(),
				sideOnTurn().opposite());
	}


	private boolean isNeighborSameSide(TilePosition pos, Offset2D direction){
        try {
            if(!board().tileAt(new TilePosition(pos.i + direction.x, pos.j + direction.y)).hasTroop()) return false;
            PlayingSide neighborSide = board().tileAt(new TilePosition(pos.i + direction.x, pos.j + direction.y)).troop().side();

            return neighborSide == sideOnTurn();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
