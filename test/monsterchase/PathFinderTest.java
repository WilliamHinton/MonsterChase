/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.util.List;
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
public class PathFinderTest {
    
    public PathFinderTest() {
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
     * Test of checkPath method, of class PathFinder.
     */
    @Test
    public void testCheckPath() {
        System.out.println("checkPath");
        Pair potentialGoalPoint = null;
        PathFinder instance = null;
        boolean expResult = false;
        boolean result = instance.checkPath(potentialGoalPoint);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deepCopy method, of class PathFinder.
     */
    @Test
    public void testDeepCopy() {
        System.out.println("deepCopy");
        int[][] original = null;
        int[][] expResult = null;
        int[][] result = PathFinder.deepCopy(original);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNeighbors method, of class PathFinder.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");
        Node current = null;
        int[][] map = null;
        PathFinder instance = null;
        List<Node> expResult = null;
        List<Node> result = instance.getNeighbors(current, map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
