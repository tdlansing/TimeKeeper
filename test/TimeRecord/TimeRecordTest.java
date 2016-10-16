/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeRecord;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bob
 */
public class TimeRecordTest {
    
    public TimeRecordTest() {
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
     * Test of getProjectID method, of class TimeRecord.
     */
    @Test
    public void testGetProjectID() {
        System.out.println("getProjectID");
        TimeRecord instance = new TimeRecord();
        int expResult = 0;
        int result = instance.getProjectID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setProjectID method, of class TimeRecord.
     */
    @Test
    public void testSetProjectID() {
        System.out.println("setProjectID");
        int projectID = 5;
        TimeRecord instance = new TimeRecord();
        instance.setProjectID(projectID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonID method, of class TimeRecord.
     */
    @Test
    public void testGetPersonID() {
        System.out.println("getPersonID");
        TimeRecord instance = new TimeRecord();
        int expResult = 0;
        int result = instance.getPersonID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonID method, of class TimeRecord.
     */
    @Test
    public void testSetPersonID() {
        System.out.println("setPersonID");
        int personID = 4;
        TimeRecord instance = new TimeRecord();
        instance.setPersonID(personID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getStartOrStop method, of class TimeRecord.
     */
    @Test
    public void testGetStartOrStop() {
        System.out.println("getStartOrStop");
        TimeRecord instance = new TimeRecord();
        char expResult = 'S';
        char result = instance.getStartOrStop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStartOrStop method, of class TimeRecord.
     */
    @Test
    public void testSetStartOrStop() {
        System.out.println("setStartOrStop");
        char startOrStop = 'E';
        TimeRecord instance = new TimeRecord();
        instance.setStartOrStop(startOrStop);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDateAndTime method, of class TimeRecord.
     */
    @Test
    public void testGetDateAndTime() {
        System.out.println("getDateAndTime");
        TimeRecord instance = new TimeRecord();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getDateAndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDateAndTime method, of class TimeRecord.
     */
    @Test
    public void testSetDateAndTime() {
        System.out.println("setDateAndTime");
        TimeRecord instance = new TimeRecord();
        instance.setDateAndTime(LocalDateTime.now());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
