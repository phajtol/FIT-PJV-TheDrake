package ceckari.thedrake.game;

import ceckari.thedrake.media.GameStateMedia;
import java.util.List;

public interface GameState {

    public Board board();
    public TroopStacks troopStacks();
    public PlayingSide sideOnTurn();
    public Leaders leaders();
    public boolean isVictory();
  
    public List<Move> allMoves();
    public List<Move> boardMoves(TilePosition position);
    public List<Move> stackMoves();
    public <T> T putToMedia(GameStateMedia <T> media);
}
