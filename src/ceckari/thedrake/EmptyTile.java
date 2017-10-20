package ceckari.thedrake;


/**
 *
 */
public class EmptyTile extends Tile {

    /**
     *
     * @param position
     */
    public EmptyTile(TilePosition position) {
        super(position);
    }


    /**
     *
     * @param troop
     * @return
     */
    @Override
    public boolean acceptsTroop(Troop troop) {
        return true;
    }


    /**
     *
     * @return
     */
    @Override
    public boolean hasTroop() {
        return false;
    }


    /**
     *
     * @return
     */
    @Override
    public Troop troop() {
        throw new UnsupportedOperationException("No troop here."); 
    }
    
}
