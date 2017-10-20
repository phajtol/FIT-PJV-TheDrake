package ceckari.thedrake;


/**
 *
 * @author friedtad & hajtopet
 */
public class Troop {

    /**
     *
     */
    private final TroopInfo info;

    /**
     *
     */
    private final PlayingSide side;

    /**
     *
     */
    private final TroopFace face;


    /**
     *
     * @param info
     * @param side
     * @param face
     */
    public Troop(TroopInfo info, PlayingSide side, TroopFace face)
    {
        this.info = info;
        this.side = side;
        this.face = face;
    }


    /**
     *
     * @return
     */
    public TroopInfo info()
    {
        return info;
    }


    /**
     *
     * @return
     */
    public PlayingSide side()
    {
        return side;
    }


    /**
     *
     * @return
     */
    public TroopFace face()
    {
        return face;
    }


    /**
     *
     * @return
     */
    public Offset2D pivot()
    {
        return info.pivot(face);
    }


    /**
     *
     * @return
     */
    public Troop flipped()
    {
        return new Troop(info,side,(face == TroopFace.FRONT)?(TroopFace.BACK):(TroopFace.FRONT));
    }
    
}
