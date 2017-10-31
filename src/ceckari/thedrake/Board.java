package ceckari.thedrake;


/**
 * Class that represents board in game The Drake.
 * @author friedtad & hajtopet
 */
public class Board {

    /**
     * Board consists of tiles (dimension squared) and list of captured troops.
     */
    private Tile [][] board;
    private int dimension;
    private CapturedTroops captured;


    /**
     * Creates new board of empty tiles with given dimension and places given troops on the board.
     * @param dimension - dimension of the board
     * @param tiles - tiles to be placed on the board (optional)
     */
    public Board(int dimension, Tile... tiles){
        this.dimension = dimension;
        board = new Tile[dimension][dimension];
        
        for(int i = 0; i < dimension; ++i)
            for(int j = 0; j < dimension; ++j)
                board[i][j] = new EmptyTile(new TilePosition(i,j));
        
        for(Tile t : tiles)
            board[t.position().i][t.position().j] = t;
    }


    /**
     * Private constuctor to alter board.
     * @param dimension
     * @param tiles
     */
    private Board(int dimension, Tile[][] tiles){
        this.dimension = dimension;
        board = tiles.clone();
        for(int i = 0; i < dimension; ++i)
            board[i] = tiles[i].clone();
    }


    /**
     * @return - dimension of the board
     */
    public int dimension(){
        return dimension;
    }


    /**
     * @param position - position
     * @return - "Tile" at given position
     */
    public Tile tileAt(TilePosition position){
        if(position.i >= dimension || position.j >= dimension || position.i < 0 || position.j < 0)
            throw new IllegalArgumentException("Position out of board!");

        return board[position.i][position.j];
    }


    /**
     * Method checks whether tile positions give are on the board.
     * @param positions - array of positions to check
     * @return - true if all tile positions are on the board, false otherwise
     */
    public boolean contains(TilePosition... positions){
        for(TilePosition t : positions)
            if(t.i >= dimension || t.j >= dimension || t.i < 0 || t.j < 0) return false;

        return true;
    }


    /**
     * Creates new instance of board with changed tiles.
     * @param tiles - array of changed tiles
     * @return - new board
     */
    public Board withTiles(Tile... tiles){
        Tile[][] newTiles = board.clone();

        for(int i = 0; i < dimension; ++i)
            newTiles[i] = board[i].clone();

        for(Tile t : tiles)
            newTiles[t.position().i][t.position().j] = t;

        return new Board(dimension, newTiles);
    }


    /**
     * Creates new instance of board with changed tiles and captured units.
     * @param info - captured troop
     * @param side - side of the captured troop
     * @param tiles - array of changed tiles
     * @return - new board
     */
    public Board withCaptureAndTiles(TroopInfo info, PlayingSide side, Tile... tiles){
        captured = captured.withTroop(side,info);
        return withTiles(tiles);
    }


    /**
     * Checks whether there's an unit on the specified position.
     * @param origin - position to check
     * @return - true if there's unit on the given position, false otherwise
     */
    public boolean canTakeFrom(TilePosition origin){
        if(tileAt(origin) instanceof EmptyTile) return false;
        return true;
    }


    /*
     * Lze na danou pozici postavit zadanou jednotku? Zde se řeší pouze
     * jednotky na hrací ploše, tedy není potřeba kontrolovat, jestli
     * sem jednotka může vstoupit pokud ji hráč bere ze zásobníku.
     */
    public boolean canPlaceTo(Troop troop, TilePosition target){
        if(tileAt(target) instanceof EmptyTile) return true;
        return false;
    }


    // Může zadaná jednotka zajmout na pozici target soupeřovu jednotku?
    public boolean canCaptureOn(Troop troop, TilePosition target){
        if(tileAt(target).hasTroop() && (tileAt(target).troop().side() == troop.side().opposite())) return true;
        return false;
    }


    /*
     * Stojí na políčku origin jednotka, která může udělat krok na pozici target
     * bez toho, aby tam zajala soupeřovu jednotku?
     */
    public boolean canStepOnly(TilePosition origin, TilePosition target){
        if((tileAt(origin) instanceof TroopTile) && !tileAt(target).hasTroop()) return true;
        return false;
    }


    /*
     * Stojí na políčku origin jednotka, která může zůstat na pozici origin
     * a zajmout soupeřovu jednotku na pozici target?
     */
    public boolean canCaptureOnly(TilePosition origin, TilePosition target){
        if(tileAt(target).hasTroop() && (tileAt(target).troop().side() == tileAt(origin).troop().side().opposite())) return true;
        return false;
    }


    /*
     * Stojí na pozici origin jednotka, která může udělat krok na pozici target
     * a zajmout tam soupeřovu jednotku?
     */
    public boolean canStepAndCapture(TilePosition origin, TilePosition target){
        return canStepOnly(origin,target) && canCaptureOn(tileAt(origin).troop(),target);
    }


    /*
     * Nová hrací deska, ve které jednotka na pozici origin se přesunula
     * na pozici target bez toho, aby zajala soupeřovu jednotku.
     */
    public Board stepOnly(TilePosition origin, TilePosition target){
        return withTiles(new TroopTile(target,tileAt(origin).troop().flipped()),new EmptyTile(origin));
    }


    /*
     * Nová hrací deska, ve které jednotka na pozici origin se přesunula
     * na pozici target, kde zajala soupeřovu jednotku.
     */
    /**
     * Creates new board, where troop at position origin moved to position target and captured other side's troop.
     * @param origin - source position of troop
     * @param target - destination of troop
     * @return - new board instance
     */
    public Board stepAndCapture(TilePosition origin, TilePosition target){
        Troop attacker = tileAt(origin).troop();
        Troop targetTroop = tileAt(target).troop();

        return withCaptureAndTiles(
                targetTroop.info(),
                targetTroop.side(),
                new EmptyTile(origin),
                new TroopTile(target, attacker.flipped())
        );
    }


    /*
     * Nová hrací deska, ve které jednotka zůstává stát na pozici origin
     * a zajme soupeřovu jednotku na pozici target.
     */
    public Board captureOnly(TilePosition origin, TilePosition target){
        Troop targetTroop = tileAt(target).troop();
        return  withCaptureAndTiles(
                targetTroop.info(),
                targetTroop.side(),
                new EmptyTile(target)
        );
    }
    
    
    public CapturedTroops captured(){
        return captured;
    }

}
