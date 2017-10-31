package ceckari.thedrake;


/**
 * @author friedtad & hajtopet
 */
public class CaptureOnly extends BoardChange {

    public CaptureOnly(Board initialBoard, TilePosition origin, TilePosition target){
        super(initialBoard, origin, target);
    }


    public Board resultBoard(){
        return initialBoard.captureOnly(origin,target);
    }

}
