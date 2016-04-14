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
public class GrassTest{
	private static Universe universe;
	
	public GrassTest() { }
	
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
     * Test of ch method, of class Grass.
     */
    @Test
    public void testCh() {
        System.out.println("ch");
        Grass instance = new Grass(universe,3,3,0.0f);
        char expResult = 'G';
        char result = instance.ch();
        assertEquals(expResult, result);
    }

    /**
     * Test of age method, of class Grass.
     */
    @Test
    public void testAge() {
        System.out.println("age");
        Grass instance = new Grass(universe,3,3,0.0f);
        int expResult = 30000;
        int result = instance.age();
        assertEquals(expResult, result);
    }

    /**
     * Test of power method, of class Grass.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        Grass instance = new Grass(universe,3,3,0.0f);
        int expResult = 2;
        int result = instance.power();
        assertEquals(expResult, result);
    }

    /**
     * Test of tgrow method, of class Grass.
     */
    @Test
    public void testTGrow() {
        System.out.println("tGrow");
        Grass instance = new Grass(universe,3,3,0.0f);
        float expResult = 0.5f;
        float result = instance.tgrow();
        assertEquals(expResult, result, 0.0);
    }
}


