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
        Space thisSpace;
        
        map = new ArrayList<>();
        //map = new ArrayList<ArrayList<Space>>();

        ArrayList<Space> mapRow = new ArrayList<>();
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                thisSpace = new Space(i, j, SpaceType.OPEN);
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
    
    public void printMap() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        //File mapFile = new File(Util.MAP_LOCATION + "myMap.txt");
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
