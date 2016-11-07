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
import java.util.Arrays;
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
    private void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fileObject = line.split("\\" + Character.toString(separator));
                Project thisProject = new Project();
                thisProject.setProjectID(Integer.parseInt(fileObject[0]));
                boolean activeStatus = false;
                if (fileObject[1].equals("A")) {
                    activeStatus = true;
                }
                thisProject.setActiveFlag(activeStatus);
                thisProject.setName(fileObject[2]);
                thisProject.setDescription(fileObject[3]);
                projects.add(thisProject);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
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
     *
     * @param projectID ID of the person being searched for.
     * @return Object for the projectID given.
     */
    public Project getProject(int projectID) {
        readFile();
        Project selectedProject = null;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getProjectID() == projectID) {
                selectedProject = projects.get(i);
            }
        }
        return selectedProject;
    }

    /**
     * Returns the Project object for the name given.
     *
     * @param projectName Name of the project being searched for.
     * @return Object for the projectID given.
     */
    public Project getProject(String projectName) {
        readFile();
        Project selectedProject = null;
        for (int i = 0; i < projects.size(); i++) {
            String name = projects.get(i).getName();
            if (name == projectName) {
                selectedProject = projects.get(i);
            }
        }
        return selectedProject;
    }

    public Project getActiveProject() {
        readFile();
        Project selectedProject = null;
        for (int i = 0; i < projects.size(); i++) {
            if (selectedProject.isActiveFlag() == true) {
                selectedProject = projects.get(i);

            }
        }
        return selectedProject;
    }

    public ArrayList<Project> getProjects() {
        readFile();
        return projects;

    }

//    public Project[] getActiveTableProjects() {
//        // calls the readFile() so the ArrayList projects is populated 
//        readFile();
//        // instantiates an Array of Projects from the ArrayList converted 
//        // into a 1 dimensional array called projArr
//        Project[] fullProjArr = projects.toArray(new Project[projects.size()]);
//        // sorts the array by natural order
//        Arrays.sort(fullProjArr);
//
//        // Set variable to store number of active records.
//        int numberOfActiveRecords = 0;
//        
//        // Get numer of records that are active.
//        for (int row = 0; row < fullProjArr.length; row++){
//            if(fullProjArr[row].isActiveFlag()){
//                numberOfActiveRecords++;
//            }
//        }
//        
//        // Get records that are active.
//        Project[] selectedRecords = new Project[numberOfActiveRecords];
//        int locationOfRecordToAdd = 0;
//        
//        for (int row = 0; row < fullProjArr.length; row++){
//            if(fullProjArr[row].isActiveFlag()){
//                selectedRecords[locationOfRecordToAdd] = fullProjArr[row];
//                locationOfRecordToAdd++;
//            }
//        }
//        // Return parts of those records that are asked for.
//        
//        // creates a 2 dimensional array named project
//        //Project[][] project = new Project[selectedRecords.length][10];
//
////        //for (int row = 0; row < project.length; row++) {
////            for (int col = 0; col < project.length; col++) {
////                // this needs to be changed to true when the set active flag is 
////                // fixed.
////                if(projects. isActiveFlag() == true){
////                project[row][col] = projArr[row];
////                }
////            }
////
////        }
//        return selectedRecords;
//    }
    

    
    
}
