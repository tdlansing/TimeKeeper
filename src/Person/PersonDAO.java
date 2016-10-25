/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim Lansing
 */
public class PersonDAO {
    
    /**
     * ArrayList storing all of the Person objects from the file.
     */
    private ArrayList<Person> people = new ArrayList<Person>();
    
    /**
     * Separator for when storing data in a file.
     */
    private char separator = '|';
    
    /**
     * Name of the file.
     */
    private final String filename = "person_data.txt";
    
    /**
     * Reads data from file and stores it in the appropriate ArrayList.
     */
    private void readFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fileObject = line.split("\\" + Character.toString(separator));
                Person thisPerson = new Person();
                thisPerson.setPersonID(Integer.parseInt(fileObject[0]));
                thisPerson.setFirstName(fileObject[1]);
                thisPerson.setLastName(fileObject[2]);
                thisPerson.setPassword(fileObject[3]);
                thisPerson.setSecurityRole(fileObject[4]);
                people.add(thisPerson);
            }
            reader.close();
        }catch(FileNotFoundException ex){
            System.err.println("File \"" + filename + "\" could not be found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("There was an error reading from the file.\nError: ");
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        
        
    }
    
    /**
     * Returns the Person object for the personID given.
     * @param personID ID of the person being searched for.
     * @return Object for the personID given.
     */
    public Person getPerson(int personID){
        readFile();
        Person selectedPerson = null;
        for (int i = 0; i < people.size(); i++){
            if (people.get(i).getPersonID() == personID){
                selectedPerson = people.get(i);
            }
        }
        return selectedPerson;
    }
    
    /**
     * Returns the Person object for the name given.
     * @param personName Name of the person being searched for.
     * @return Object for the personID given.
     */
    public Person getPerson(String personName){
        readFile();
        Person selectedPerson = null;
        for (int i = 0; i < people.size(); i++){
            String name = people.get(i).getFirstName() + " " + people.get(i).getLastName();
            if (name.toLowerCase().equals(personName.toLowerCase())){   //Added to remove case sensitivity in evaluating names.
                selectedPerson = people.get(i);
            }
        }
        return selectedPerson;
    }
}
