package cudlici.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import cudlici.thedrake.game.EmptyTile;
import cudlici.thedrake.game.PlayingSide;
import cudlici.thedrake.game.TheDrakeSetup;
import cudlici.thedrake.game.Tile;
import cudlici.thedrake.game.TilePosition;
import cudlici.thedrake.game.Troop;
import cudlici.thedrake.game.TroopFace;
import cudlici.thedrake.game.TroopInfo;
import cudlici.thedrake.game.TroopTile;

public class TileFromPlainText {
	private final TheDrakeSetup setup;
	private final BufferedReader reader;
	
	public TileFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.setup = setup;
		this.reader = reader;
	}
	
	public Tile readTile(TilePosition position) throws IOException {
		String line = reader.readLine();
		
		if("empty".equals(line)) {
			return new EmptyTile(position);
		}
		
		String[] fields = line.split(" ");
		TroopInfo info = setup.infoByName(fields[0]);
		PlayingSide side = PlayingSide.valueOf(fields[1]); 
		TroopFace face = TroopFace.valueOf(fields[2]);
		Troop troop = new Troop(info, side, face);		
		return new TroopTile(position, troop);
	}
}
