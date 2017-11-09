package ceckari.thedrake.media;

import ceckari.thedrake.game.EmptyTile;
import ceckari.thedrake.game.TroopTile;

public interface TileMedia<T> {
	public T putTroopTile(TroopTile tile);	
	public T putEmptyTile(EmptyTile tile);
}
