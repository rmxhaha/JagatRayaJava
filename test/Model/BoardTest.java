/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class BoardTest {
    
    public BoardTest() {
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
     * Test of GetW method, of class Board.
     */
    @Test
    public void testGetW() {
        System.out.println("GetW");
        Board instance = new Board(10,1);
        int expResult = 10;
        int result = instance.GetW();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetH method, of class Board.
     */
    @Test
    public void testGetH() {
        System.out.println("GetH");
        Board instance = new Board(1,10);
        int expResult = 10;
        int result = instance.GetH();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetEl method, of class Board.
     */
    @Test
    public void testGetEl() {
        System.out.println("GetEl");
        int _h = 1;
        int _w = 2;
        Board instance = new Board(3,3);
        StringBuffer expResult = new StringBuffer("a");
        instance.SetEl('a', _h, _w);
        StringBuffer result = instance.GetEl(_h, _w);
        assertEquals(result.toString(), expResult.toString());
    }

    /**
     * Test of SetEl method, of class Board.
     */
    @Test
    public void testSetEl() {
        System.out.println("SetEl");
        char c = ' ';
        int _h = 1;
        int _w = 2;
        Board instance = new Board(3,3);
        StringBuffer expResult = new StringBuffer();
        expResult.append(c);
        instance.SetEl(c, _h, _w);
        StringBuffer result = instance.GetEl(_h, _w);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of DelEl method, of class Board.
     */
    @Test
    public void testDelEl() {
        System.out.println("DelEl");
        char c = '@';
        int _h = 1;
        int _w = 2;
        Board instance = new Board(3,3);
        StringBuffer expResult = new StringBuffer("");
        instance.SetEl(c, _h, _w);
        instance.DelEl(c, _h, _w);
        StringBuffer result = instance.GetEl(_h, _w);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of isEmpty method, of class Board.
     */
    @Test
    public void testIsEmpty() {
        Board instance = new Board(3,3);
        boolean result;

        System.out.println("isEmpty empty");
        result = instance.isEmpty();
        assertEquals(true, result);

        System.out.println("isEmpty not empty");
        instance.SetEl('@',1,1);

        result = instance.isEmpty();
        assertEquals(false, result);
    }    
}
