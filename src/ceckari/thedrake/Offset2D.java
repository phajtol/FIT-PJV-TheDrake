package ceckari.thedrake;


/**
 *
 * @author friedtad & hajtopet
 */
public class Offset2D {

    /**
     *
     */
    public final int x;
    public final int y;


    /**
     *
     * @param x
     * @param y
     */
    public Offset2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean equalsTo(int x, int y)
    {
        return (this.x == x) && (this.y == y);
    }


    /**
     *
     * @return
     */
    public Offset2D yFlipped()
    {
        return new Offset2D(x, -y);
    }
    
    
}
