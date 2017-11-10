package ceckari.thedrake.media.plaintext;

import ceckari.thedrake.game.EmptyTile;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.TroopFace;
import ceckari.thedrake.game.TroopTile;
import ceckari.thedrake.media.PrintMedia;
import ceckari.thedrake.media.TileMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class TilePlainTextMedia extends PrintMedia implements TileMedia<Void> {

    public TilePlainTextMedia(OutputStream stream){
        super(stream);
    }

    @Override
    public Void putTroopTile(TroopTile tile) {
        PrintWriter w = writer();

        w.print(
                tile.troop().info().name() +
                ((tile.troop().side() == PlayingSide.BLUE) ? " BLUE" : " ORANGE") +
                ((tile.troop().face() == TroopFace.FRONT) ? " FRONT" : " BACK")
        );

        return null;
    }

    @Override
    public Void putEmptyTile(EmptyTile tile) {
        PrintWriter w = writer();

        w.print("empty");

        return null;
    }
}
