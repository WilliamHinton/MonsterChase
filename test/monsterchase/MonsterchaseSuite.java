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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Will
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({monsterchase.SpaceTest.class, monsterchase.SpaceTypeTest.class, monsterchase.MonsterTest.class, monsterchase.PathFinderTest.class, monsterchase.NodeTest.class, monsterchase.MonsterChaseTest.class, monsterchase.PairTest.class, monsterchase.PathFinderAStarTest.class, monsterchase.MapTest.class, monsterchase.UtilTest.class, monsterchase.MapGeneratorTest.class, monsterchase.SpaceAsciiTableTest.class, monsterchase.ZombieTest.class})
public class MonsterchaseSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
