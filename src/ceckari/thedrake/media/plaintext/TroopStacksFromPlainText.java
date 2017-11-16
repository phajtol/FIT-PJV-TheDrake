package ceckari.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ceckari.thedrake.game.BasicTroopStacks;
import ceckari.thedrake.game.PlayingSide;
import ceckari.thedrake.game.TheDrakeSetup;
import ceckari.thedrake.game.TroopInfo;
import ceckari.thedrake.game.TroopStacks;

public class TroopStacksFromPlainText {
	private final TheDrakeSetup setup;
	private final BufferedReader reader;
	
	public TroopStacksFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.setup = setup;
		this.reader = reader;
	}
	
	public TroopStacks readTroopStacks() throws IOException {
		List<TroopInfo> blueTroops = readList(PlayingSide.BLUE);
		List<TroopInfo> orangeTroops = readList(PlayingSide.ORANGE);
		
		return new BasicTroopStacks(blueTroops, orangeTroops);
	}
	
	private List<TroopInfo> readList(PlayingSide side) throws IOException {
		String line = reader.readLine();
		String[] parts = line.split(" ");
		
		List<TroopInfo> result = new ArrayList<>();
		for(int i = 2; i < parts.length; i++) {
			result.add(setup.infoByName(parts[i]));
		}
		
		return result;
	}
}

