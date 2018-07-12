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
        int[][] emptyCellArray = new int [height][width];
        int cellSpreadingPower;
        spawnCoordinates = new Pair(getStart(width), getStart(height));
        generationCoordinates = new Pair(getStart(width), getStart(height));
        ArrayList<Space> mapRow;
        Space space = new Space(-1,-1,SpaceType.OPEN);
        Pair goal;
        
        for(int i = 0; i < seedCount; i++){
            cellSpreadingPower = (height * width) / 8;
            generationCoordinates = new Pair(getStart(width), getStart(height));
            try{
            while(cellSpreadingPower > 0){
                emptyCellArray[generationCoordinates.getY()][generationCoordinates.getX()] = 1;
                generationCoordinates = cellFiller(emptyCellArray, generationCoordinates);
                cellSpreadingPower--;
            }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                generationCoordinates.printPair();
                System.out.println("(" + emptyCellArray[0].length + ", " + emptyCellArray.length + ")");
            }
        }
        
        emptyCellArray[spawnCoordinates.getY()][spawnCoordinates.getX()] = 2;
        
        goal = setGoal(emptyCellArray);
        
        emptyCellArray[goal.getY()][goal.getX()] = 3;
        
        for(int y = 0; y < height; y ++){
            mapRow = new ArrayList<>();
            for(int x = 0; x < width; x++){
                if(emptyCellArray[y][x] == 0){
                    space = new Space(x, y, SpaceType.OPEN);
                }
                
                else if(emptyCellArray[y][x] == 1){
                    space = new Space(x, y, SpaceType.CLOSED);
                }
                
                else if(emptyCellArray[y][x] == 2){
                    space = new Space(x, y, SpaceType.PLAYER);
                }
                
                else if(emptyCellArray[y][x] == 3){
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
        while(potentialGoalPoint.equals(spawnCoordinates)){
            potentialGoalPoint = new Pair(getStart(width), getStart(height));
        }
        
        while(true){
            PathFinderAStar verifyDoable = new PathFinderAStar(mapArray, spawnCoordinates, potentialGoalPoint);
            if(verifyDoable.doesPathExist() && spawnCoordinates != potentialGoalPoint){
                return potentialGoalPoint;
            }
            else
                potentialGoalPoint = new Pair(getStart(width), getStart(height));
        }
    }
}
    

    

    
