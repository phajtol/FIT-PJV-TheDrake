package ceckari.thedrake.ui;

import java.io.InputStream;

import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.TroopFace;
import javafx.scene.image.Image;

public class TroopImageSet {

  private final Image troopFrontB;
  private final Image troopBackB;
  private final Image troopFrontO;
  private final Image troopBackO;

  public TroopImageSet(String troopName) {
	troopFrontB = new Image(assetFromJAR("front" + troopName + "B"));
	troopBackB = new Image(assetFromJAR("back" + troopName + "B"));
	troopFrontO = new Image(assetFromJAR("front" + troopName + "O"));
	troopBackO = new Image(assetFromJAR("back" + troopName + "O"));
  }

  private InputStream assetFromJAR(String fileName) {
	return getClass().getResourceAsStream("/assets/" + fileName + ".png");
  }

  public Image get(PlayingSide side, TroopFace face) {
	if (side == PlayingSide.BLUE) {
	  if (face == TroopFace.FRONT) {
		return troopFrontB;
	  } else {
		return troopBackB;
	  }
	} else {
	  if (face == TroopFace.FRONT) {
		return troopFrontO;
	  } else {
		return troopBackO;
	  }
	}
  }
}
