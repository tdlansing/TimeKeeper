/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Tony
 */
public class RenderID extends DefaultTableCellRenderer {

    public RenderID() {
       setTableCellAlignment();
    }
    
    private void setTableCellAlignment(){
        setHorizontalAlignment(SwingConstants.CENTER);
        
        
    }
    
    
}
