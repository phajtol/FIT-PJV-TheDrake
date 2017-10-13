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
public class TroopInfo {
    
    private final String name;
    private final Offset2D frontPivot;
    private final Offset2D backPivot;

    public TroopInfo(String name, Offset2D frontPivot, Offset2D backPivot) {
        this.name = name;
        this.frontPivot = frontPivot;
        this.backPivot = backPivot;
    }

    public String name() {
        return name;
    }
    
    public Offset2D pivot(TroopFace face){
        if(face == TroopFace.FRONT) return frontPivot;
        else return backPivot;
    }
    
}
