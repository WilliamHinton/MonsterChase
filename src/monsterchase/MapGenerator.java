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
public class MapGenerator {
    private int height;
    private int width;
    private int generationPoint;
    private ArrayList<ArrayList<Space>> map;
    
    public MapGenerator (int height, int width, ArrayList<ArrayList<Space>> map){
        this.height = height;
        this.width = width;
        this.map = map;
    }
    
    public ArrayList<ArrayList<Space>> newMap(){
        int cellSpreadingPower = (height * width) / 4;
        int[] emptyCellArray = new int [height * width];
        generationPoint = getStart();
        ArrayList<Space> mapRow;
        Space space = new Space(-1,-1,SpaceType.OPEN);
        int cellTracker = 0;
        
        while(cellSpreadingPower > 0){
            emptyCellArray[generationPoint] = 1;
            generationPoint = cellFiller(emptyCellArray);
            cellSpreadingPower--;
        }
        
        for(int y = 0; y < height; y ++){
            mapRow = new ArrayList<>();
            for(int x = 0; x < width; x++){
                if(emptyCellArray[cellTracker] == 0){
                    space = new Space(x, y, SpaceType.OPEN);
                }
                
                else if(emptyCellArray[cellTracker] == 1){
                    space = new Space(x, y, SpaceType.CLOSED);
                }
                mapRow.add(space);
                cellTracker++;
            }
            
            map.add(mapRow);
        }
        
        return map;
    }
    
    private int cellFiller(int[] cellArray){
        int down = generationPoint + width;
        int up = generationPoint - width;
        int left = generationPoint - 1;
        int right = generationPoint + 1;
        ArrayList<Integer> availableOptions = new ArrayList<>();
        
        if(left >= 0 &&generationPoint % width != 0 && cellArray[left] == 0)
            availableOptions.add(left);
        if(right < cellArray.length && (generationPoint + 1) % width != 0 && cellArray[left] == 0)
            availableOptions.add(right);
        if(up >= 0 && cellArray[left] == 0)
            availableOptions.add(up);
        if(down < cellArray.length && cellArray[left] == 0)
            availableOptions.add(down);
        
        if(availableOptions.size() == 0){
            generationPoint = getStart();
            cellFiller(cellArray);
        }
        
        else{
            generationPoint = availableOptions.get((int)(Math.random() * availableOptions.size()));
        }
        
        return generationPoint;
    }
    
    private int getStart(){
        int start = (int)(Math.random() * (height * width));
        
        return start;
    }
    
}
