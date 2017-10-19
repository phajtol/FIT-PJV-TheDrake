package ceckari.thedrake;

/**
 *
 * @author friedtad
 */
public abstract class Tile {
    private final TilePosition position;
    
    protected Tile(TilePosition position){
        this.position=position;
    }
    public TilePosition position(){
        return position;
    }
    public abstract boolean acceptsTroop(Troop troop);
    public abstract boolean hasTroop();
    public abstract Troop troop();
    
}
