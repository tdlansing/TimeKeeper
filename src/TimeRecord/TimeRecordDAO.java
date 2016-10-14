/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeRecord;

import Person.Person;
import Person.PersonDAO;
import Project.Project;
import Project.ProjectDAO;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim Lansing
 */
public class TimeRecordDAO {
    
/**
     * Separator for when storing data in a file.
     */
    private char separator = '|';
    
    /**
     * Name of the file.
     */
    private final String filename = "time_record_data.txt";
    
    /**
     * Appends new entry to the time_record_data.txt file.
     * @param lineToAppend Line to add to the file.
     */
    private void writeFile(String lineToAppend){
        try{
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(lineToAppend);
            out.close();
        }catch(FileNotFoundException ex){
            System.err.println("File \"" + filename + "\" could not be found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("There was an error writing to the file.\nError: ");
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }
    
    public TimeRecord appendTimeRecord(int newProjectID, int newPersonID, char newStartOrStop){
        TimeRecord newTimeRecord=new TimeRecord();
        newTimeRecord.setDateAndTime(LocalDateTime.now());
        newTimeRecord.setPersonID(newPersonID);
        newTimeRecord.setProjectID(newProjectID);
        newTimeRecord.setStartOrStop(newStartOrStop);
        String lineToAdd = Integer.toString(newProjectID) + "|" +  Integer.toString(newPersonID) + "|" + 
                Character.toString(newStartOrStop) + "|" + newTimeRecord.getDateAndTime().toString();
        writeFile(lineToAdd);
        return newTimeRecord;
    }
    
    public TimeRecord appendTimeRecord(String newProjectName, String newPersonName, char newStartOrStop){
        
        // Get the Person object to look up the person ID.
        PersonDAO accessPeople = new PersonDAO();
        Person thisPerson = accessPeople.getPerson(newPersonName);
        if (thisPerson == null){
            System.out.println("A person with the name \"" + newPersonName + "\" could not be found.");
            System.exit(-1);
        }
        
        // Get the Project object to look up the project ID.
        ProjectDAO accessProjects = new ProjectDAO();
        Project thisProject = accessProjects.getProject(newProjectName);
        if (thisProject == null){
            System.out.println("A project with the name \"" + newProjectName + "\" could not be found.");
            System.exit(-1);
        }
        
        return appendTimeRecord(thisProject.getProjectID(), thisPerson.getPersonID(), newStartOrStop);
    }
}
