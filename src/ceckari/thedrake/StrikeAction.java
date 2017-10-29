package ceckari.thedrake;


import java.util.List;
import java.util.Collections;


public class StrikeAction implements TroopAction {

    private final Offset2D direction;

    StrikeAction(int dirX, int dirY){
        this(new Offset2D(dirX, dirY));
    }


    StrikeAction(Offset2D direction){
        this.direction = direction;
    }


    @Override
    public List<BoardChange> changesFrom(TilePosition origin, PlayingSide side, Board board) {
        return null;
    }

}
