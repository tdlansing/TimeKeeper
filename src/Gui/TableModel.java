/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eric Walton
 */
public class TableModel extends AbstractTableModel {
    
    String[] columnNames = {"Project ID", "Active", "Project Name", "Project Description"};
    Object[][] test1 = {{1, false, "A", "Sample Description"},
                        {2, false, "A", "Sample Description"},
                        {3, false, "A", "Sample Description"},
                        {4, false, "A", "Sample Description"},
                        {5, false, "A", "Sample Description"},
                        {6, false, "A", "Sample Description"},
                        {7, false, "A", "Sample Description"},
                        {8, false, "A", "Sample Description"},
                        {9, false, "A", "Sample Description"},
                        {10, false, "A", "Sample Description"},
                        {11, false, "A", "Sample Description"},
                        {12, false, "A", "Sample Description"},
                        {13, false, "A", "Sample Description"}
                        };
    /**
     * 
     * @return 
     */
    @Override
    public int getRowCount() {
        return test1.length;
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
        return test1[rowIndex][columnIndex];
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
    public boolean isCellEditable(int row,int column){
        return true;
    }
    /**
     * 
     * @param value
     * @param row
     * @param column 
     */
    @Override
    public void setValueAt(Object value, int row, int column){
        test1[row][column] = value;
    }
    
}// end of class
