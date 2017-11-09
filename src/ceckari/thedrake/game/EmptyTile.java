package ceckari.thedrake.game;


/**
 *Class that represents one empty tile in game The Drake.
 * @author friedtad & hajtopet
 */
public class EmptyTile extends Tile {

    /**
     * Constructor of empty tile. Calls a parent (Tile) construcor.
     * @param position
     */
    public EmptyTile(TilePosition position) {
        super(position);
    }


    /**
     *
     * @param troop
     * @return true always for empty tile
     */
    @Override
    public boolean acceptsTroop(Troop troop) {
        return true;
    }


    /**
     * Method returning info about occupancy of tile
     * @return false always for empty tile
     */
    @Override
    public boolean hasTroop() {
        return false;
    }


    /**
     * Getter method returning troop present on tile. Always throws an exception for empty tile.
     * @return 
     */
    @Override
    public Troop troop() {
        throw new UnsupportedOperationException("No troop here."); 
    }
    
}
