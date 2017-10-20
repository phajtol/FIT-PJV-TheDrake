package ceckari.thedrake;


/**
 *
 * @author friedtad & hajtopet
 */
public class TroopTile extends Tile {

    /**
     *
     */
    Troop troop;


    /**
     *
     * @param position
     * @param troop
     */
    public TroopTile(TilePosition position, Troop troop)
    {
        super(position);
        this.troop = troop;
    }


    /**
     *
     * @param troop
     * @return
     */
    @Override
    public boolean acceptsTroop(Troop troop)
    {
        return false;
    }


    /**
     *
     * @return
     */
    @Override
    public boolean hasTroop()
    {
        return true;
    }


    /**
     *
     * @return
     */
    @Override
    public Troop troop()
    {
        return troop;
    }
    
}
