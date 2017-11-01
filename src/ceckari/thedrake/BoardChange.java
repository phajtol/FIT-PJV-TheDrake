package ceckari.thedrake;


/**
 * @author friedtad & hajtopet
 */
public abstract class BoardChange {

    protected final Board initialBoard;
    protected final TilePosition origin;
    protected final TilePosition target;


    /*
     * Konstruktor, který bere hrací desku, ze které vycházíme a poté
     * dvě souřadnice, jedna, ze které tah vychází a druhá, na kterou
     * tah směřuje.
     */
    protected BoardChange(Board initialBoard, TilePosition origin, TilePosition target){
        this.initialBoard = initialBoard;
        this.origin = origin;
        this.target = target;
    }


    /**
     * @return - initial board
     */
    public Board initialBoard(){
        return initialBoard;
    }


    /**
     * @return - origin
     */
    public TilePosition origin(){
        return origin;
    }


    /**
     * @return - target
     */
    public TilePosition target(){
        return target;
    }

    /*
     * Metoda, která vrací novou hrací desku vyrobenou podle toho,
     * jaký tah zrovna provádíme.
     */
    public abstract Board resultBoard();
}
