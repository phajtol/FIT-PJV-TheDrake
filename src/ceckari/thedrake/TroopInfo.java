package ceckari.thedrake;


import java.util.Collections;
import java.util.List;

/**
 *
 * @author friedtad & hajtopet
 */
public class TroopInfo {

    /**
     *
     */
    private final String name;
    private final Offset2D frontPivot;
    private final Offset2D backPivot;
    private final List<TroopAction> frontActions;
    private final List<TroopAction> backActions;


    /**
     *
     * @param name
     * @param frontPivot
     * @param backPivot
     */
    public TroopInfo(String name, Offset2D frontPivot, Offset2D backPivot, List<TroopAction> frontActions, List<TroopAction> backActions)
    {
        this.name = name;
        this.frontPivot = frontPivot;
        this.backPivot = backPivot;
        this.frontActions = frontActions;
        this.backActions = backActions;
    }

    /**
     *
     * @param name
     * @param pivot
     */
    public TroopInfo (String name, Offset2D pivot, List<TroopAction> frontActions, List<TroopAction> backActions)
    {
        this(name, pivot, pivot, frontActions, backActions);
    }


    /**
     *
     * @param name
     */
    public TroopInfo (String name, List<TroopAction> frontActions, List<TroopAction> backActions)
    {
        this(name,new Offset2D(1,1), frontActions, backActions);
    }


    /**
     *
     * @return
     */
    public String name()
    {
        return name;
    }


    /**
     *
     * @param face
     * @return
     */
    public Offset2D pivot(TroopFace face)
    {
        if(face == TroopFace.FRONT) return frontPivot;
        else return backPivot;
    }


    public List<TroopAction> actions(TroopFace face){
        if(face == TroopFace.FRONT) return Collections.unmodifiableList(frontActions);
        return Collections.unmodifiableList(backActions);
    }
    
}
