package ceckari.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import ceckari.thedrake.game.EmptyTile;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.TheDrakeSetup;
import ceckari.thedrake.game.Tile;
import ceckari.thedrake.game.TilePosition;
import ceckari.thedrake.game.Troop;
import ceckari.thedrake.game.TroopFace;
import ceckari.thedrake.game.TroopInfo;
import ceckari.thedrake.game.TroopTile;

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
