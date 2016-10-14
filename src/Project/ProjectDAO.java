/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

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
public class ProjectDAO {
    
    /**
     * ArrayList storing all of the Project objects from the file.
     */
    private ArrayList<Project> projects = new ArrayList<Project>();
    
    /**
     * Separator for when storing data in a file.
     */
    private char separator = '|';
    
    /**
     * Name of the file.
     */
    private final String filename = "project_data.txt";
    
    /**
     * Reads data from file and stores it in the appropriate ArrayList.
     */
    private void readFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fileObject = line.split("\\" + Character.toString(separator));
                Project thisProject = new Project();
                thisProject.setProjectID(Integer.parseInt(fileObject[0]));
                boolean activeStatus = false;
                if(fileObject[1] == "A"){
                    activeStatus = true;
                }
                thisProject.setActiveFlag(activeStatus);
                thisProject.setName(fileObject[2]);
                thisProject.setDescription(fileObject[3]);
                projects.add(thisProject);
            }
            reader.close();
        }catch(FileNotFoundException ex){
            System.err.println("File \"" + filename + "\" could not be found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("There was an error reading from the file.\nError: ");
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }
    
    /**
     * Returns the Project object for the projectID given.
     * @param projectID ID of the person being searched for.
     * @return Object for the projectID given.
     */
    public Project getProject(int projectID){
        readFile();
        Project selectedProject = null;
        for (int i = 0; i < projects.size(); i++){
            if (projects.get(i).getProjectID() == projectID){
                selectedProject = projects.get(i);
            }
        }
        return selectedProject;
    }
    
    /**
     * Returns the Project object for the name given.
     * @param projectName Name of the project being searched for.
     * @return Object for the projectID given.
     */
    public Project getProject(String projectName){
        readFile();
        Project selectedProject = null;
        for (int i = 0; i < projects.size(); i++){
            String name = projects.get(i).getName();
            if (name == projectName){
                selectedProject = projects.get(i);
            }
        }
        return selectedProject;
    }

    
}





    


    

