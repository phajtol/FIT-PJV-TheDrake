
package ceckari.thedrake.media;

import ceckari.thedrake.game.MiddleGameState;
import ceckari.thedrake.game.PlacingGuardsGameState;
import ceckari.thedrake.game.PlacingLeadersGameState;
import ceckari.thedrake.game.VictoryGameState;

public interface GameStateMedia<T> {
	public T putPlacingLeadersGameState(PlacingLeadersGameState state);
	public T putPlacingGuardsGameState(PlacingGuardsGameState state);
	public T putMiddleGameState(MiddleGameState state);
	public T putFinishedGameState(VictoryGameState state);
}

