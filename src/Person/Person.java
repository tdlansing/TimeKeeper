/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

/**
 *
 * @author Tim Lansing
 */
public class Person {
    
    /**
     * Constructor
     */
    public Person(){
        personID = 0;
        firstName = "";
        lastName = "";
        password = "password";
        securityRole = "user";
    }
    
    /**
     * Id of the person.
     */
    private int personID;
    
    /**
     * First name of the person.
     */
    private String firstName;
    
    /**
     * Last name of the person.
     */
    private String lastName;
    
    /**
     * Password of the person.
     */
    private String password;
    
    /** 
     * Security role of the person.
     */
    private String securityRole;

    /**
     * @return the personID
     */
    public int getPersonID() {
        return personID;
    }

    /**
     * @param personID the personID to set
     */
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the securityRole
     */
    public String getSecurityRole() {
        return securityRole;
    }

    /**
     * @param securityRole the securityRole to set
     */
    public void setSecurityRole(String securityRole) {
        this.securityRole = securityRole;
    }
    
}
