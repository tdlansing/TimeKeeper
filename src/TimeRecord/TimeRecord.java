/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeRecord;

import java.time.LocalDateTime;

/**
 *
 * @author Tim Lansing
 */
public class TimeRecord {
    
    /**
     * The ID of the project.
     */
    private int projectID;
    
    /**
     * The ID of the person.
     */
    private int personID;
    
    /**
     * Character indicating start or stop.
     * 'S' for start and 'E' for end/stop.
     */
    private char startOrStop;
    
    /**
     * Date and time for the records entry.
     */
    private LocalDateTime dateAndTime;

    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

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
     * @return the startOrStop
     */
    public char getStartOrStop() {
        return startOrStop;
    }

    /**
     * @param startOrStop the startOrStop to set
     */
    public void setStartOrStop(char startOrStop) {
        this.startOrStop = startOrStop;
    }

    /**
     * @return the dateAndTime
     */
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    /**
     * @param dateAndTime the dateAndTime to set
     */
    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
