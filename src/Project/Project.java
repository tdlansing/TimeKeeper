/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author Tim Lansing
 */
public class Project {
    
    /**
     * ID of the project.
     */
    private int projectID;
    
    /**
     * Flag showing whether the project is active or not.
     */
    private boolean activeFlag;
    
    /**
     * Name of the project.
     */
    private String name;
    
    /**
     * Description of the project.
     */
    private String description;

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
     * @return the activeFlag
     */
    public boolean isActiveFlag() {
        return activeFlag;
    }

    /**
     * @param activeFlag the activeFlag to set
     */
    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
