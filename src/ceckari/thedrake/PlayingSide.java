package ceckari.thedrake;


/**
 * Java enum for colours of players.
 * @author friedtad & hajtopet
 */
public enum PlayingSide
{
    BLUE, ORANGE {
        @Override
        public PlayingSide opposite(){
            return BLUE;
        }
    };

    public PlayingSide opposite(){
        return ORANGE;
    }
}
