/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceckari.thedrake;

/**
 *
 * @author peter
 */
public class Offset2D {
    
    public final int x;
    public final int y;

    public Offset2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean equalsTo(int x, int y){
        return (this.x == x) && (this.y == y);
    }
    
    public Offset2D yFlipped(){
        return new Offset2D(x, -y);
    }
    
    
}
