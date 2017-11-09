package ceckari.thedrake.game;

import ceckari.thedrake.media.TileMedia;


/**
 * Abstract class for a tile on a board of the game The Drake. 
 * @author friedtad & hajtopet
 */
public abstract class Tile {

    /**
     * Every tile has some position on the board.
     */
    private final TilePosition position;


    /**
     * Constructor assigning a position to the position variable.
     * @param position
     */
    protected Tile(TilePosition position)
    {
        this.position = position;
    }


    /**
     * Getter of position on the board.
     * @return position on the board.
     */
    public TilePosition position()
    {
        return position;
    }


    /**
     * Method returning true for tile which is possible to enter be given troop.
     * @param troop that wants to enter the tile.
     * @return info if the troop can enter the tile.
     */
    public abstract boolean acceptsTroop(Troop troop);


    /**
     * Method returning true for occupied tile.
     * @return info about tile occupancy.
     */
    public abstract boolean hasTroop();


    /**
     * Getter of 
     * @return
     */
    public abstract Troop troop();
    
    
    public abstract <T> T putToMedia(TileMedia <T> media);
    
}
