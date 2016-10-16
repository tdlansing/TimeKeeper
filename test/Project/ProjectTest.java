/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

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
public class ProjectTest {
    
    public ProjectTest() {
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
     * Test of getProjectID method, of class Project.
     */
    @Test
    public void testGetProjectID() {
        System.out.println("getProjectID");
        Project instance = new Project();
        int expResult = 0;
        int result = instance.getProjectID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setProjectID method, of class Project.
     */
    @Test
    public void testSetProjectID() {
        System.out.println("setProjectID");
        int projectID = 5;
        Project instance = new Project();
        instance.setProjectID(projectID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isActiveFlag method, of class Project.
     */
    @Test
    public void testIsActiveFlag() {
        System.out.println("isActiveFlag");
        Project instance = new Project();
        boolean expResult = true;
        boolean result = instance.isActiveFlag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActiveFlag method, of class Project.
     */
    @Test
    public void testSetActiveFlag() {
        System.out.println("setActiveFlag");
        boolean activeFlag = false;
        Project instance = new Project();
        instance.setActiveFlag(activeFlag);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Project.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Project instance = new Project();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Project.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Bob";
        Project instance = new Project();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Project.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Project instance = new Project();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Project.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Cool project.";
        Project instance = new Project();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Project.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Project instance = new Project();
        String expResult = "Project: 0 , Active";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Project.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object o = new Project();
        Project instance = new Project();
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
