package ceckari.thedrake.game;


/**
 *
 * @author friedtad & hajtopet
 */
public enum TroopFace
{
    FRONT, BACK {
        @Override
        public TroopFace flipped() {
            return FRONT;
        }
    };

    public TroopFace flipped() {
        return BACK;
    }
}
