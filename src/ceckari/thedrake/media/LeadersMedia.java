package ceckari.thedrake.media;

import ceckari.thedrake.game.BothLeadersPlaced;
import ceckari.thedrake.game.NoLeadersPlaced;
import ceckari.thedrake.game.OneLeaderPlaced;

public interface LeadersMedia<T> {
	public T putNoLeadersPlaced(NoLeadersPlaced leaders);
	public T putOneLeaderPlaced(OneLeaderPlaced leaders);
	public T putBothLeadersPlaced(BothLeadersPlaced leaders);
}
