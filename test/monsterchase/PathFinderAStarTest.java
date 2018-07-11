/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

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
public class PathFinderAStarTest {
    
        Pair start = new Pair(0,0);
        Pair end = new Pair(3,3);
        int[][] map = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,2}};
        PathFinderAStar instance = new PathFinderAStar(map, start, end);
    public PathFinderAStarTest() {
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
     * Test of checkAndUpdateCost method, of class PathFinderAStar.
     */
    @Test
    public void testCheckAndUpdateCost() {
        System.out.println("checkAndUpdateCost");
        Node n = new Node(1,1);
        Node current = new Node(1,2);
        int cost = 1;
        instance.checkAndUpdateCost(n, current, cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class PathFinderAStar.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Pair start = new Pair(0,0);
        Pair end = new Pair(3,3);
        int[][] map = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,2}};
        PathFinderAStar instance = new PathFinderAStar(map, start, end);
        boolean expResult = true;
        boolean result = instance.getPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    

    /**
     * Test of deepCopy method, of class PathFinderAStar.
     */
    @Test
    public void testDeepCopy() {
        System.out.println("deepCopy");
        int[][] original = {{1, 1, 1, 1},{2, 2, 2, 2},{3,3,3,3},{4,4,4,4}};
        int[][] result = PathFinderAStar.deepCopy(original);
        assertNotSame(original, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
