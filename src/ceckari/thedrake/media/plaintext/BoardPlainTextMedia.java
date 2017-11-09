package cudlici.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;

import cudlici.thedrake.game.Board;
import cudlici.thedrake.game.Tile;
import cudlici.thedrake.media.BoardMedia;
import cudlici.thedrake.media.PrintMedia;

public class BoardPlainTextMedia extends PrintMedia implements BoardMedia<Void> {
	private final TilePlainTextMedia tileMedia;
	private final CapturedTroopsPlainTextMedia capturedMedia;
	
	public BoardPlainTextMedia(OutputStream stream) {
		super(stream);
		this.tileMedia = new TilePlainTextMedia(stream);
		this.capturedMedia = new CapturedTroopsPlainTextMedia(stream);
	}
	
	@Override
	public Void putBoard(Board board) {
		PrintWriter w = writer();

		w.println(board.dimension());
		for(Tile tile : board) {
			tile.putToMedia(tileMedia);
			w.println();
		}
		
		capturedMedia.putCapturedTroops(board.captured());
		
		return null;
	}
}
