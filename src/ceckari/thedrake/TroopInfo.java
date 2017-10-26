package ceckari.thedrake;


/**
 *
 * @author friedtad & hajtopet
 */
public class TroopInfo {

    /**
     *
     */
    private final String name;

    /**
     *
     */
    private final Offset2D frontPivot;

    /**
     *
     */
    private final Offset2D backPivot;


    /**
     *
     * @param name
     * @param frontPivot
     * @param backPivot
     */
    public TroopInfo(String name, Offset2D frontPivot, Offset2D backPivot)
    {
        this.name = name;
        this.frontPivot = frontPivot;
        this.backPivot = backPivot;
    }

    /**
     *
     * @param name
     * @param pivot
     */
    public TroopInfo (String name, Offset2D pivot)
    {
        this(name, pivot, pivot);
    }


    /**
     *
     * @param name
     */
    public TroopInfo (String name)
    {
        this(name,new Offset2D(1,1));
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
    
}
