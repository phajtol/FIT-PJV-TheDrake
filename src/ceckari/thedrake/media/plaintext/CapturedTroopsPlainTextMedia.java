package ceckari.thedrake.media.plaintext;

import ceckari.thedrake.game.CapturedTroops;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.Troop;
import ceckari.thedrake.game.TroopInfo;
import ceckari.thedrake.media.CapturedTroopsMedia;
import ceckari.thedrake.media.PrintMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class CapturedTroopsPlainTextMedia extends PrintMedia implements CapturedTroopsMedia<Void>
{
    CapturedTroopsPlainTextMedia(OutputStream stream){
        super(stream);
    }

    @Override
    public Void putCapturedTroops(CapturedTroops captured) {
        PrintWriter w = writer();

        w.print("Captured BLUE: " + captured.troops(PlayingSide.BLUE).size());
        for(TroopInfo t : captured.troops(PlayingSide.BLUE)) {
            w.print(t.name());
            w.println();
        }

        w.print("Captured ORANGE: " + captured.troops(PlayingSide.ORANGE).size());
        for(TroopInfo t : captured.troops(PlayingSide.ORANGE)) {
            w.print(t.name());
            w.println();
        }

        return null;
    }
}
