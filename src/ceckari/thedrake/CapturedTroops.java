package ceckari.thedrake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 */
public class CapturedTroops {

    /**
     * Lists of captured units, one list for each playing side.
     */
    private final List<TroopInfo> blue;
    private final List<TroopInfo> orange;


    /**
     * Constructor creates empty list.
     */
    public CapturedTroops(){
        blue = new ArrayList<TroopInfo>();
        orange = new ArrayList<TroopInfo>();
    }


    /**
     * Private constructor used to add new troops.
     * @param blue - list of captured troops of blue side
     * @param orange - list of captured troops of orange side
     * @param side - side, to which the newly captured troop belongs
     * @param info - newly captured troop to be added to list
     */
    private CapturedTroops(List<TroopInfo> blue, List<TroopInfo> orange, PlayingSide side, TroopInfo info){
        this.blue = blue;
        this.orange = orange;

        if(side == PlayingSide.BLUE) blue.add(0,info);
        else orange.add(0,info);
    }

    /**
     * @param side -
     * @return - list of captured troops for given side
     */
    public List<TroopInfo> troops(PlayingSide side){
        if(side == PlayingSide.BLUE) return Collections.unmodifiableList(blue);
        return Collections.unmodifiableList(orange);
    }

    /**
     * Creates new instance with added troop.
     * @param side - which side does the captured troop belong to
     * @param info - captured troop
     * @return - new instance of CapturedTroops with changes
     */
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info){
        return new CapturedTroops(this.blue,this.orange,side,info);
    }

}
