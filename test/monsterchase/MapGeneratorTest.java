/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Will
 */
public class MapGeneratorTest {
    
    public MapGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newMap method, of class MapGenerator.
     */
    @Test
    public void testNewMap() {
        System.out.println("newMap");
        ArrayList<ArrayList<Space>>map = new ArrayList<>();
        MapGenerator instance = new MapGenerator(5,5,map,0);
        ArrayList<ArrayList<Space>> expResult = null;
        ArrayList<ArrayList<Space>> result = instance.newMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
