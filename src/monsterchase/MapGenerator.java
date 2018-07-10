/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Will
 */
public class MapGenerator {
    private int height;
    private int width;
    private int seedCount;
    private Pair generationCoordinates;
    private Pair spawnCoordinates;
    private ArrayList<ArrayList<Space>> map;
    
    public MapGenerator (int height, int width, ArrayList<ArrayList<Space>> map, int seedCount){
        this.height = height;
        this.width = width;
        this.map = map;
        this.seedCount = seedCount;
    }
    
    public ArrayList<ArrayList<Space>> newMap(){
        int[][] emptyCellArray = new int [width][height];
        int cellSpreadingPower;
        spawnCoordinates = new Pair(getStart(width), getStart(height));
        generationCoordinates = new Pair(getStart(width),getStart(height));
        ArrayList<Space> mapRow;
        Space space = new Space(-1,-1,SpaceType.OPEN);
        Pair goal;
        
        for(int i = 0; i < seedCount; i++){
            cellSpreadingPower = (height * width) / 8;
            generationCoordinates = new Pair(getStart(width),getStart(height));
            while(cellSpreadingPower > 0){
                emptyCellArray[generationCoordinates.getX()][generationCoordinates.getY()] = 1;
                generationCoordinates = cellFiller(emptyCellArray, generationCoordinates);
                cellSpreadingPower--;
            }
        }
        
        emptyCellArray[spawnCoordinates.getX()][spawnCoordinates.getY()] = 2;
        
        goal = setGoal(emptyCellArray);
        
        emptyCellArray[goal.getX()][goal.getY()] = 3;
        
        for(int y = 0; y < height; y ++){
            mapRow = new ArrayList<>();
            for(int x = 0; x < width; x++){
                if(emptyCellArray[x][y] == 0){
                    space = new Space(x, y, SpaceType.OPEN);
                }
                
                else if(emptyCellArray[x][y] == 1){
                    space = new Space(x, y, SpaceType.CLOSED);
                }
                
                else if(emptyCellArray[x][y] == 2){
                    space = new Space(x, y, SpaceType.PLAYER);
                }
                
                else if(emptyCellArray[x][y] == 3){
                    space = new Space(x, y, SpaceType.GOAL);
                }
                
                else{
                    space = new Space(x, y, SpaceType.ERROR);
                }
                mapRow.add(space);
            }
            map.add(mapRow);
        }
        
        return map;
    }
    
    private Pair cellFiller(int[][] cellArray, Pair coords){
        int down = coords.getY() + 1;
        int up = coords.getY() - 1;
        int left = coords.getX() - 1;
        int right = coords.getX() + 1;
        ArrayList<Pair> availableOptions = new ArrayList<>();
        
        if(left >= 0)
            availableOptions.add(new Pair(left, coords.getY()));
        if(right < width)
            availableOptions.add(new Pair(right, coords.getY()));
        if(up >= 0)
            availableOptions.add(new Pair(coords.getX(), up));
        if(down < height)
            availableOptions.add(new Pair(coords.getX(), down));
        
        coords = availableOptions.get((int)(Math.random() * availableOptions.size()));
        
        return coords;
    }
    
    private int getStart(int max){
        int start = (int)(Math.random() * max);
        
        return start;
    }
    
    private Pair setGoal(int [][] mapArray){
        Pair potentialGoalPoint = new Pair(getStart(width), getStart(height));
        //System.out.println(potentialGoalPoint.getX() + ", " + potentialGoalPoint.getY());
        //PathFinder verifyDoable = new PathFinder(mapArray);
        PathFinderAStar verifyDoable = new PathFinderAStar(mapArray, potentialGoalPoint, spawnCoordinates);
        
        
        while(true){
            System.out.println(potentialGoalPoint.getX() + ", " + potentialGoalPoint.getY());
            if(verifyDoable.getPath())
                break;
            else
                potentialGoalPoint = new Pair(getStart(width), getStart(height));
        }
        //if(verifyDoable.getPath()){
        //    return potentialGoalPoint;
        //}
        
        return(setGoal(mapArray));
    }
}
    

    

    
