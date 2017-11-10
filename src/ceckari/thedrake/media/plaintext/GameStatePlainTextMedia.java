package ceckari.thedrake.media.plaintext;

import ceckari.thedrake.game.*;
import ceckari.thedrake.media.GameStateMedia;
import ceckari.thedrake.media.PrintMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class GameStatePlainTextMedia extends PrintMedia implements GameStateMedia<Void> {
    private final BoardPlainTextMedia boardMedia;
    private final TroopStacksPlainTextMedia troopStacksMedia;
    private final LeadersPlainTextMedia leadersMedia;

    public GameStatePlainTextMedia(OutputStream stream){
        super(stream);
        boardMedia = new BoardPlainTextMedia(stream);
        troopStacksMedia = new TroopStacksPlainTextMedia(stream);
        leadersMedia = new LeadersPlainTextMedia(stream);

    }


    @Override
    public Void putPlacingLeadersGameState(PlacingLeadersGameState state) {
        PrintWriter w = writer();

        w.println("LEADERS");
        w.println(0);
        w.println(state.sideOnTurn() == PlayingSide.BLUE ? "BLUE" : "ORANGE");

        state.troopStacks().putToMedia(troopStacksMedia);
        state.leaders().putToMedia(leadersMedia);
        //state.board().putToMedia(boardMedia);
        boardMedia.putBoard(state.board());

        return null;
    }


    @Override
    public Void putPlacingGuardsGameState(PlacingGuardsGameState state) {
        PrintWriter w = writer();

        w.println("GUARDS");
        w.println(state.guardsCount());
        w.println(state.sideOnTurn() == PlayingSide.BLUE ? "BLUE" : "ORANGE");

        state.troopStacks().putToMedia(troopStacksMedia);
        state.leaders().putToMedia(leadersMedia);
        //state.board().putToMedia(boardMedia);
        boardMedia.putBoard(state.board());

        return null;
    }


    @Override
    public Void putMiddleGameState(MiddleGameState state) {
        PrintWriter w = writer();

        w.println("MIDDLE");
        w.println(4);
        w.println(state.sideOnTurn() == PlayingSide.BLUE ? "BLUE" : "ORANGE");

        state.troopStacks().putToMedia(troopStacksMedia);
        state.leaders().putToMedia(leadersMedia);
        //state.board().putToMedia(boardMedia);
        boardMedia.putBoard(state.board());

        return null;
    }


    @Override
    public Void putFinishedGameState(VictoryGameState state) {
        PrintWriter w = writer();

        w.println("VICTORY");
        w.println(4);
        w.println(state.sideOnTurn() == PlayingSide.BLUE ? "BLUE" : "ORANGE");

        state.troopStacks().putToMedia(troopStacksMedia);
        state.leaders().putToMedia(leadersMedia);
        //state.board().putToMedia(boardMedia);
        boardMedia.putBoard(state.board());

        return null;
    }
}
