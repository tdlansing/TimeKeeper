/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

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
public class PersonTest {
    
    public PersonTest() {
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
     * Test of getPersonID method, of class Person.
     */
    @Test
    public void testGetPersonID() {
        System.out.println("getPersonID");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.getPersonID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonID method, of class Person.
     */
    @Test
    public void testSetPersonID() {
        System.out.println("setPersonID");
        int personID = 5;
        Person instance = new Person();
        instance.setPersonID(personID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Person.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Person.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Tom";
        Person instance = new Person();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Person.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Person.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Smith";
        Person instance = new Person();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        ///fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Person.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Person instance = new Person();
        String expResult = "password";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Person.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "NewPassword!!";
        Person instance = new Person();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSecurityRole method, of class Person.
     */
    @Test
    public void testGetSecurityRole() {
        System.out.println("getSecurityRole");
        Person instance = new Person();
        String expResult = "user";
        String result = instance.getSecurityRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSecurityRole method, of class Person.
     */
    @Test
    public void testSetSecurityRole() {
        System.out.println("setSecurityRole");
        String securityRole = "administrator";
        Person instance = new Person();
        instance.setSecurityRole(securityRole);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
