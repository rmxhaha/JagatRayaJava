/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Utility.IntPair;
import Model.Board;
import Model.Universe;
import Model.Creature.Alien;
import Model.Creature.Grass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rmx
 */
public class AlienTest {
    private static Universe universe;
    
    public AlienTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        int w = 5;
        int h = 5;
        int N = 1;
        
        try {
            Board b = new Board(w,h);
            universe = new Universe(b,N);
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
     * Test of find method, of class Alien.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        IntPair preyCoordinate = new IntPair(0,0);
        IntPair predatorCoordinate = new IntPair(3,3);
        universe.board.SetEl('D', 1, 1);
        Alien instance = new Alien(universe,3,3,0.0f);

        boolean expResult = true;
        boolean result = instance.find(preyCoordinate, predatorCoordinate);
        assertEquals(expResult, result);
        assertEquals(preyCoordinate.getFirst(), 3);
        assertEquals(preyCoordinate.getSecond(), 3);

        // clean up
        universe.board.DelEl('D', 1, 1);
    }

    /**
     * Test of ch method, of class Alien.
     */
    @Test
    public void testCh() {
        System.out.println("ch");
        Alien instance = new Alien(universe,3,3,0.0f);
        char expResult = '@';
        char result = instance.ch();
        assertEquals(expResult, result);
    }

    /**
     * Test of age method, of class Alien.
     */
    @Test
    public void testAge() {
        System.out.println("age");
        Alien instance = new Alien(universe,3,3,0.0f);
        int expResult = 3;
        int result = instance.age();
        assertEquals(expResult, result);
    }

    /**
     * Test of power method, of class Alien.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        Alien instance = new Alien(universe,3,3,0.0f);
        int expResult = 50;
        int result = instance.power();
        assertEquals(expResult, result);
    }

    /**
     * Test of speed method, of class Alien.
     */
    @Test
    public void testSpeed() {
        System.out.println("speed");
        Alien instance = new Alien(universe,3,3,0.0f);
        float expResult = 50000.f;
        float result = instance.speed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of interact method, of class Alien.
     */
    @Test
    public void testInteract() {
        System.out.println("interact");
        Alien instance = new Alien(universe,3,3,0.0f);
        Grass grass = new Grass(universe,3,3,0.0f);
        
        instance.interact(grass);
        assertTrue(grass.isDead());
    }
    
}
