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
public class HumanTest{
	private static Universe universe;
	
	public HumanTest() { }
	
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
     * Test of update method, of class Human.
     */
     @Test
     public void testUpdate(){
		 System.out.println("Update");
		 Human instance = new Human(universe,1,1,0.0f);
		 int dx = instance.getX();
		 int dy = instance.getY();
                // force update only once
                instance.update(1000/instance.speed()+1);

                assertTrue( dx != instance.getX() || dy != instance.getY());
	 }
	 
	 /**
     * Test of ch method, of class Human.
     */
    @Test
    public void testCh() {
        System.out.println("ch");
        Human instance = new Human(universe,3,3,0.0f);
        char expResult = 1;
        char result = instance.ch();
        assertEquals(expResult, result);
    }

    /**
     * Test of age method, of class Human.
     */
    @Test
    public void testAge() {
        System.out.println("age");
        Human instance = new Human(universe,3,3,0.0f);
        int expResult = 50000;
        int result = instance.age();
        assertEquals(expResult, result);
    }

    /**
     * Test of power method, of class Human.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        Human instance = new Human(universe,3,3,0.0f);
        int expResult = 1;
        int result = instance.power();
        assertEquals(expResult, result);
    }

    /**
     * Test of speed method, of class Human.
     */
    @Test
    public void testSpeed() {
        System.out.println("speed");
        Human instance = new Human(universe,3,3,0.0f);
        float expResult = 3.f;
        float result = instance.speed();
        assertEquals(expResult, result, 0.0);
    }

}


