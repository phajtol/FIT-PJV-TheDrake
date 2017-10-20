package ceckari.thedrake;


/**
 * Class that represents board in game The Drake.
 * @author friedtad & hajtopet
 */
public class Board {

    /**
     * Board consists of tiles.
     */
    private Tile [][] board;


    /**
     * Dimension of board.
     */
    private int dimension;


    /**
     *
     * @param dimension
     * @param tiles
     */
    public Board(int dimension, Tile... tiles)
    {
        this.dimension = dimension;
        board = new Tile[dimension][dimension];
        
        for(int i = 0; i < dimension; ++i)
            for(int j = 0; j < dimension; ++j)
                board[i][j] = new EmptyTile(new TilePosition(i,j));
        
        for(Tile t : tiles)
            board[t.position().i][t.position().j] = t;
    }


    /**
     * Alternative constructor for creating new board.
     * @param dimension
     * @param tiles
     */
    private Board(int dimension, Tile[][] tiles)
    {
        this.dimension = dimension;
        board = tiles.clone();
        for(int i = 0; i < dimension; ++i)
            board[i] = tiles[i].clone();
    }


    /**
     * Getter.
     * @return - dimension of the board
     */
    public int dimension()
    {
        return dimension;
    }


    /**
     * Returns tile at given
     * @param position - position
     * @return - "Tile" at given position
     */
    public Tile tileAt(TilePosition position)
    {
        if(position.i >= dimension || position.j >= dimension || position.i < 0 || position.j < 0)
            throw new IllegalArgumentException("Position out of board!");

        return board[position.i][position.j];
    }


    /**
     * Method checks whether tile positions give are on the board.
     * @param positions - array of positions to check
     * @return - true if all tile positions are on the board, false otherwise
     */
    public boolean contains(TilePosition... positions)
    {
        for(TilePosition t : positions)
            if(t.i >= dimension || t.j >= dimension || t.i < 0 || t.j < 0) return false;

        return true;
    }


    /**
     * Creates new same board with changed tiles.
     * @param tiles - array of changed tiles
     * @return - new board
     */
    public Board withTiles(Tile... tiles)
    {
        Tile[][] newTiles = board.clone();

        for(int i = 0; i < dimension; ++i)
            newTiles[i] = board[i].clone();

        for(Tile t : tiles)
            newTiles[t.position().i][t.position().j] = t;

        return new Board(dimension, newTiles);
    }


}
