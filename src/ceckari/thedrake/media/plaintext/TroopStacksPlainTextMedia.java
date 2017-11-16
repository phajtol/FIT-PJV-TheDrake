package ceckari.thedrake.media.plaintext;

import ceckari.thedrake.game.BasicTroopStacks;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.TroopInfo;
import ceckari.thedrake.media.PrintMedia;
import ceckari.thedrake.media.TroopStacksMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class TroopStacksPlainTextMedia extends PrintMedia implements TroopStacksMedia<Void> {

    public TroopStacksPlainTextMedia(OutputStream stream){
        super(stream);
    }


    @Override
    public Void putBasicTroopStacks(BasicTroopStacks stacks) {
        PrintWriter w = writer();

        w.print("BLUE stack:");
        for(TroopInfo t : stacks.troops(PlayingSide.BLUE))
            w.print(" " + t.name());
        w.println();

        w.print("ORANGE stack:");
        for(TroopInfo t : stacks.troops(PlayingSide.ORANGE))
            w.print(" " + t.name());
        w.println();

        return null;
    }
}
