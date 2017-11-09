package ceckari.thedrake.game;

import java.util.ArrayList;
import java.util.List;


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
    
    public Troop(TroopInfo info, PlayingSide side){
        this(info,side,TroopFace.FRONT);
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
    public List<BoardChange> changesFrom(TilePosition pos, Board board){
        List<BoardChange> result = new ArrayList<BoardChange>();
        for(TroopAction a:this.info.actions(this.face)){
            result.addAll(a.changesFrom(pos, side, board));
        }
        return result;

    }
    
}
