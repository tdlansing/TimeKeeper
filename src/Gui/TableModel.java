/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Project.Project;
import Project.ProjectDAO;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author Eric Walton
 */
public class TableModel extends AbstractTableModel {

    private ArrayList<Project> projects = null;

    private Project[] projectsArr = null;

    private ArrayList<Project> activeProjObs = null;
    Project proj = new Project(); // doesn't seem to be used
    ProjectDAO pDAO = new ProjectDAO();

    public TableModel() {
        projects = pDAO.getProjects();
        
        activeProjObs = new ArrayList<Project>();
            
        String output = "Added record for: ";
        for (Project proj : projects) {
            if (proj.isActiveFlag()){
               activeProjObs.add(proj);
               output += (proj.getName() + ", ");
            }
        }
      //  JOptionPane.showMessageDialog(null, output, "InfoBox: " + output, JOptionPane.INFORMATION_MESSAGE);
       
        projectsArr = activeProjObs.toArray(new Project[activeProjObs.size()]);

        Arrays.sort(projectsArr);
    }

    /**
     * I think this is really all that is needed for the column names
     */
    String[] columnNames = {"Project ID", "Project Name"};

    /**
     * original sample data stored in multidimensional array. - no longer using.
     */
    public void setProject() {
        projects = pDAO.getProjects();
    }

    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return projectsArr.length;
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Project thisProject = projectsArr[rowIndex];

        Object[][] project = {{thisProject.getProjectID(), thisProject.getName()}};
        return project[0][columnIndex];

    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /**
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}// end of class
