/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
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
        this.map = new ArrayList<>();
        MapGenerator generator = new MapGenerator(height,width,map);
        
        map = generator.newMap();
    }
    

    private Space getSpaceAtCoordinates(int x, int y){
        ArrayList<Space> row = map.get(y);
        Space spaceToGet = row.get(x);
        
        return spaceToGet;
    }
    
    //prints the map to a text file
    public void printMap() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        try(Writer mapWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(Util.MAP_LOCATION + "myMap.txt")), "UTF-8"))){
            for(int y = 0; y < this.height; y++){
                for(int x = 0; x < this.width; x++){
                    mapWriter.write(getSpaceAtCoordinates(x,y).getTypeRender());
                }
                mapWriter.write("\n");
            }
            
            mapWriter.close();
        }
    }
}