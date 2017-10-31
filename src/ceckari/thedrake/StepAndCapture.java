package ceckari.thedrake;


/**
 * @author friedtad & hajtopet
 */
public class StepAndCapture extends BoardChange {

    public StepAndCapture(Board initialBoard, TilePosition origin, TilePosition target){
        super(initialBoard, origin, target);
    }


    public Board resultBoard(){
        return initialBoard.stepAndCapture(origin,target);
    }

}
