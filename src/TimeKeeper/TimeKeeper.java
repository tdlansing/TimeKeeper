/*
 * A TimeKeeper class.
 */
package TimeKeeper;

import Person.Person;
import Person.PersonDAO;
import Project.Project;
import Project.ProjectDAO;
import TimeRecord.TimeRecord;
import TimeRecord.TimeRecordDAO;
import java.time.LocalDateTime;

/**
 * This program was created to help keep track of the amount of time a person works on a given
 * project.  It will work for multiple persons and projects.
 * @author Tim Lansing
 */
public class TimeKeeper {

    /**
     * This method takes a customized message and the arguments used when starting
     * the program.  It then presents the customized message to the user along with
     * an explanation of correct usage. 
     * @param additionalMessage Message specific to why startup failed.
     * @param args The arguments the user passed to the program during startup.
     */
    private static void displayStartupErrorMessage(String additionalMessage, String[] args){
            System.err.print(additionalMessage + "\n"
                    + "Your usage was: \"java TimeKeeper");
                    for(int i = 0; i < args.length; i++){
                        System.err.print(" " + args[i]);
                    }
                    System.err.println("\"\n"
                    + "Correct usage:  \"java TimeKeeper <employeeID> <projectID> <S|E>\"\n"
                    + "\"S\" denotes start, \"E\" denotes end, and it must be capitalized.\n");
            System.exit(-1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // If there not not exactly 3 arguments then display an error message.
        if(args.length != 3){
            displayStartupErrorMessage("Sorry, but this program requires three arguments.", args);
        // Else, if the third argument isn't an S or an E then display an error message.
        } else if (!args[2].equals("S") && !args[2].equals("E")) {
            displayStartupErrorMessage("Sorry, but the third argument must be an \"S\" or an \"E\".", args);
        }
        // Continue running the program.
        
        // Get the Person object.
        PersonDAO accessPeople = new PersonDAO();
        Person thisPerson = accessPeople.getPerson(Integer.parseInt(args[0]));
        if (thisPerson == null){
            System.out.println("A person with the ID \"" + args[0] + "\" could not be found.");
            System.exit(-1);
        }
        
        // Get the Project object.
        ProjectDAO accessProjects = new ProjectDAO();
        Project thisProject = accessProjects.getProject(Integer.parseInt(args[1]));
        if (thisProject == null){
            System.out.println("A project with the ID \"" + args[1] + "\" could not be found.");
            System.exit(-1);
        }
        
        // Append line to Time Record file.
        TimeRecordDAO newTimeRecordDAO = new TimeRecordDAO();
        TimeRecord newTimeRecord = newTimeRecordDAO.appendTimeRecord(Integer.parseInt(args[1]), Integer.parseInt(args[0]), args[2].charAt(0));
        
        // Display name, project, and time.
        System.out.println("Record has been entered for:");
        System.out.println("Name:    " + thisPerson.getFirstName() + " " + thisPerson.getLastName());
        System.out.println("Project: " + thisProject.getName());
        System.out.println("S/E Code:" + newTimeRecord.getStartOrStop());
        System.out.println("Time:    " + newTimeRecord.getDateAndTime());
    }
    
}
