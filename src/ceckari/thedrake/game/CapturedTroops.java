package ceckari.thedrake.game;

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

    public CapturedTroops(List <TroopInfo> blueTroops, List <TroopInfo> orangeTroops){
        blue = blueTroops;
        orange = orangeTroops;
    }
    

    /**
     * Private constructor used to add new troops.
     * @param blue - list of captured troops of blue side
     * @param orange - list of captured troops of orange side
     * @param side - side, to which the newly captured troop belongs
     * @param info - newly captured troop to be added to list
     */
    private CapturedTroops(List<TroopInfo> blue, List<TroopInfo> orange, PlayingSide side, TroopInfo info){
        this.blue = new ArrayList<TroopInfo>();
        this.orange = new ArrayList<TroopInfo>();
        
        if(side == PlayingSide.BLUE) this.blue.add(info);
        else this.orange.add(info);
        
        this.blue.addAll(blue);
        this.orange.addAll(orange);
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
