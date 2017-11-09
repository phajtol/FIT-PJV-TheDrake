package cudlici.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import cudlici.thedrake.game.Board;
import cudlici.thedrake.game.CapturedTroops;
import cudlici.thedrake.game.TheDrakeSetup;
import cudlici.thedrake.game.Tile;
import cudlici.thedrake.game.TilePosition;

public class BoardFromPlainText {
	private final TheDrakeSetup setup;
	private final BufferedReader reader;
	
	public BoardFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.setup = setup;
		this.reader = reader;
	}
	
	public Board readBoard() throws IOException {
		String line = reader.readLine();
		int dimension = Integer.parseInt(line);
		
		int tileCount = dimension*dimension;
		Tile[] tiles = new Tile[tileCount];
		
		TileFromPlainText tileFromReader = new TileFromPlainText(setup, reader);
		for(int i = 0; i < tileCount; i++) {
			TilePosition pos = new TilePosition(i % 4, i / 4);
			tiles[i] = tileFromReader.readTile(pos);
		}
		
		CapturedTroops captured = 
				new CapturedTroopsFromPlainText(setup, reader).readTroops();
		
		return new Board(dimension, captured, tiles);
	}
}
