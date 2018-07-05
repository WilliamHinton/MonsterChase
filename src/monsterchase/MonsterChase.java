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
        Map testMap = new Map(80,80,6);
        
        testMap.printMap();
    }
    
}
