package ceckari.thedrake.ui;

import ceckari.thedrake.game.Move;

public interface TileContext {
  public void tileSelected(TileView view);
  public void execute(Move move);
}
