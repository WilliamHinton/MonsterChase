/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.util.ArrayList;

/**
 *
 * @author Will
 */
public class Map {
    ArrayList<ArrayList<Space>> map;
    private final int height;
    private final int width;
    
    Map (int height, int width){
        this.height = height;
        this.width = width;
        Space thisSpace;
        
        map = new ArrayList<>();
        //map = new ArrayList<ArrayList<Space>>();

        ArrayList<Space> mapRow = new ArrayList<>();
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                thisSpace = new Space(i, j, "open");
                mapRow.add(thisSpace);
            }
            map.add(mapRow);
        }
    }
    
    private Space getSpaceAtCoordinates(int x, int y){
        ArrayList<Space> row = map.get(y);
        Space spaceToGet = row.get(x);
        
        return spaceToGet;
    }
    
    public void printMap(){
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                System.out.print(getSpaceAtCoordinates(x,y).getType());
            }
            System.out.print("\n");
        }
    }
}
