package ceckari.thedrake;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class StrikeAction implements TroopAction {

    private final Offset2D position;

    StrikeAction(int dirX, int dirY){
        this(new Offset2D(dirX, dirY));
    }


    StrikeAction(Offset2D position){
        this.position = position;
    }


    @Override
    public List<BoardChange> changesFrom(TilePosition origin, PlayingSide side, Board board) {
        TilePosition target = origin.stepByPlayingSide(position, side);
        List<BoardChange> result = new ArrayList<>();
       

    	if(board.canCaptureOnly(origin, target))
            result.add(new CaptureOnly(board, origin, target));

    	return result;
    }

}
