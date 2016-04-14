package Model.Creature;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.*;

/**
 *
 * @author Rmx
 */
public class TurtleTest{
	private static Universe universe;
	
	public TurtleTest() { }
	
	@BeforeClass
	public static void setUpClass(){
		int w = 5;
		int h = 5;
		int N = 1;
		
		try{
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
     * Test of update method, of class Turtle.
     */
     @Test
     public void testUpdate(){
		 System.out.println("Update");
		 Turtle instance = new Turtle(universe,1,1,0.0f);
		 int dx = instance.getX();
		 int dy = instance.getY();
                // force update only once
                instance.update(1000/instance.speed()+1);

                assertTrue( dx != instance.getX() || dy != instance.getY());
	 }
	 
	 /**
     * Test of ch method, of class Turtle.
     */
    @Test
    public void testCh() {
        System.out.println("ch");
        Turtle instance = new Turtle(universe,3,3,0.0f);
        char expResult = 'U';
        char result = instance.ch();
        assertEquals(expResult, result);
    }

    /**
     * Test of age method, of class Turtle.
     */
    @Test
    public void testAge() {
        System.out.println("age");
        Turtle instance = new Turtle(universe,3,3,0.0f);
        int expResult = 20000;
        int result = instance.age();
        assertEquals(expResult, result);
    }

    /**
     * Test of power method, of class Turtle.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        Turtle instance = new Turtle(universe,3,3,0.0f);
        int expResult = 3;
        int result = instance.power();
        assertEquals(expResult, result);
    }

    /**
     * Test of speed method, of class Turtle.
     */
    @Test
    public void testSpeed() {
        System.out.println("speed");
        Turtle instance = new Turtle(universe,3,3,0.0f);
        float expResult = 2.f;
        float result = instance.speed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of interact method, of class Turtle.
     */
    @Test
    public void testInteract() {
        System.out.println("interact");
        Turtle instance = new Turtle(universe,3,3,0.0f);
        Grass grass = new Grass(universe,3,3,0.0f);
        
        instance.interact(grass);
        assertTrue(grass.isDead());
    }
}
