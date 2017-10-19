
package ceckari.thedrake;

public class Board {
    private Tile [][] board;
    private int dimension;
    public Board(int dimension, Tile... tiles){
        board=new Tile[dimension][dimension];
        for(Tile t:tiles){
            board[t.position().i][t.position().j]=t;
        }
    }
    public int dimension(){
        return this.dimension;
    }
    public Tile tileAt(TilePosition position){
        if(position.i>=dimension|| position.j>=dimension){
            throw IllegalArgumentException("Position out of board!");
        }
        
    }
    
    
}
