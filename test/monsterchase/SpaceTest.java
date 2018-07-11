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
public class SpaceTest {
    
    public SpaceTest() {
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
     * Test of getCoordinates method, of class Space.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        Space instance = null;
        Pair expResult = null;
        Pair result = instance.getCoordinates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Space.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Space instance = null;
        SpaceType expResult = null;
        SpaceType result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeRender method, of class Space.
     */
    @Test
    public void testGetTypeRender() {
        System.out.println("getTypeRender");
        Space instance = null;
        String expResult = "";
        String result = instance.getTypeRender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
