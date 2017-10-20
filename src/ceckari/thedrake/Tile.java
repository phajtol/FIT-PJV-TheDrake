package ceckari.thedrake;


/**
 *
 * @author friedtad & hajtopet
 */
public abstract class Tile {

    /**
     *
     */
    private final TilePosition position;


    /**
     *
     * @param position
     */
    protected Tile(TilePosition position)
    {
        this.position = position;
    }


    /**
     *
     * @return
     */
    public TilePosition position()
    {
        return position;
    }


    /**
     *
     * @param troop
     * @return
     */
    public abstract boolean acceptsTroop(Troop troop);


    /**
     *
     * @return
     */
    public abstract boolean hasTroop();


    /**
     *
     * @return
     */
    public abstract Troop troop();
    
}
