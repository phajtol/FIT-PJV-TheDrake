package ceckari.thedrake;


/**
 * @author friedtad & hajtopet
 */
public class StepOnly extends BoardChange {

    public StepOnly(Board initialBoard, TilePosition origin, TilePosition target){
        super(initialBoard, origin, target);
    }


    @Override
    public Board resultBoard(){
        return initialBoard.stepOnly(origin,target);
    }
}
