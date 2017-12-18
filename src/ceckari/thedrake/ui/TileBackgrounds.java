package ceckari.thedrake.ui;

import ceckari.thedrake.game.EmptyTile;
import ceckari.thedrake.game.Tile;
import ceckari.thedrake.game.TroopTile;
import ceckari.thedrake.media.TileMedia;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;

public class TileBackgrounds implements TileMedia<Background> {

  public static final Background EMPTY_BG = new Background(
		  new BackgroundFill(new Color(0.9, 0.9, 0.9, 1), null, null));

  public TileBackgrounds() {
  }

  @Override
  public Background putEmptyTile(EmptyTile tile) {
	return EMPTY_BG;
  }

  @Override
  public Background putTroopTile(TroopTile tile) {
	TroopImageSet images = new TroopImageSet(tile.troop().info().name());
	BackgroundImage bgImage = new BackgroundImage(
			images.get(tile.troop().side(), tile.troop().face()), null, null, null, null);

	return new Background(bgImage);
  }

  public Background get(Tile tile) {
	return tile.putToMedia(this);
  }
}
