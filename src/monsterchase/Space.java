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
    private String type;
    
    public Space( int x, int y, String type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
    public int[] getCoordinates(){
        int[] coordinates = new int[2];
        coordinates[0] = this.x;
        coordinates[1] = this.y;
        
        return coordinates;
    }
    
    public String getType() {
        return this.type;
    }
}
