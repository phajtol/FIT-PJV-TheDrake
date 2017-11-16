package ceckari.thedrake.game;


import ceckari.thedrake.media.TileMedia;

/**
 * Class storing a Tile occupied by a troop.
 * @author friedtad & hajtopet
 */
public class TroopTile extends Tile {

    /**
     * Troop that stands on the tile.
     */
    Troop troop;


    /**
     * Constructor calls a parent and assigning a troop standing on the tile.
     * @param position – position of the tile
     * @param troop  – troop on the tile
     */
    public TroopTile(TilePosition position, Troop troop)
    {
        super(position);
        this.troop = troop;
    }


    /**
     * Method gives info if given troop can enter on this tile.
     * @param troop
     * @return false always for occupied tile
     */
    @Override
    public boolean acceptsTroop(Troop troop)
    {
        return false;
    }


    /**
     * Method returns true if the tile is full, false for empty tile.
     * @return true for occupied tile.
     */
    @Override
    public boolean hasTroop()
    {
        return true;
    }


    /**
     * Getter method returning a troop standing on the tile.
     * @return troop on the tile
     */
    @Override
    public Troop troop()
    {
        return troop;
    }

    /**
     *
     * @param media
     * @param <T>
     * @return
     */
    @Override
    public <T> T putToMedia(TileMedia<T> media) {
        return media.putTroopTile(this);
    }
}
