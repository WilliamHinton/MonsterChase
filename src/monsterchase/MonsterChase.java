/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Will
 */

public class MonsterChase {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int height = 20;
        int width = 40;
        
        //seedValue determines how many times the grid filler will run. Higher means more fill.
        int seedValue = 0;
        Map testMap = new Map(width, height,seedValue);
        
        testMap.printMap();
    }
    
}
