package ceckari.thedrake.media.plaintext;

import ceckari.thedrake.game.BothLeadersPlaced;
import ceckari.thedrake.game.NoLeadersPlaced;
import ceckari.thedrake.game.OneLeaderPlaced;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.media.LeadersMedia;
import ceckari.thedrake.media.PrintMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class LeadersPlainTextMedia extends PrintMedia implements LeadersMedia<Void> {

    public LeadersPlainTextMedia(OutputStream stream){
        super(stream);
    }


    @Override
    public Void putNoLeadersPlaced(NoLeadersPlaced leaders) {
        PrintWriter w = writer();

        w.println("NL");

        return null;
    }


    @Override
    public Void putOneLeaderPlaced(OneLeaderPlaced leaders) {
        PrintWriter w = writer();

        w.println(
                leaders.isPlaced(PlayingSide.BLUE) ?
                        "OL " + leaders.position(PlayingSide.BLUE).toString() :
                        "OL X " + leaders.position(PlayingSide.ORANGE).toString()
        );

        return null;
    }


    @Override
    public Void putBothLeadersPlaced(BothLeadersPlaced leaders) {
        PrintWriter w = writer();

        w.println("BL " + leaders.position(PlayingSide.BLUE).toString() + " " + leaders.position(PlayingSide.ORANGE).toString());

        return null;
    }
}
