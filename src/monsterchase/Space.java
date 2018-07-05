/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

/**
 *
 * @author Will
 */
public class Space {
    private int x;
    private int y;
    private SpaceType type;
    private SpaceAsciiTable lookup = new SpaceAsciiTable();
    
    public Space( int x, int y, SpaceType type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    public Pair getCoordinates(){
        Pair coordinates = new Pair(this.x, this.y);
        
        return coordinates;
    }
    
    
    //returns the type
    public SpaceType getType() {
        return this.type;
    }
    
    //returns the type as an ASCII character
    public String getTypeRender(){
        return lookup.get(this.type);
    }
}
