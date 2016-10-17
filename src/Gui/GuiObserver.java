/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tim Lansing
 */
public class GuiObserver extends JFrame  implements Observer, ActionListener{

    String bundleName = "Gui.TimeKeeper";
    ResourceBundle userOutput = ResourceBundle.getBundle(bundleName, Locale.ENGLISH);
  
    //private static final String TITLE_TEXT = "TimeKeeper";
    private final String USER_NAME_LABEL = "User Name";
    private final int FIELD_LENGTH = 20;
    private JTextField userNameField;
    
    public GuiObserver(){
        super("Initial Title");
        initialize();        
    }
    
    //Doesn't have to be called initialize.  Could be named anything.
    private void initialize(){
        // http://www.java2s.com/Code/Java/Swing-JFC/Createamainmenu.htm
        JFrame panel = new JFrame(userOutput.getString("title_text"));
        panel.setSize(600, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setLocation(dim.width/2-panel.getSize().width/2, dim.height/2-panel.getSize().height/2);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu("Menu");
        JMenuItem jmiETR = new JMenuItem("Enter time record");
        JMenuItem jmiExit = new JMenuItem("Exit");
        jmFile.add(jmiETR);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);

        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        jmiETR.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiAbout.addActionListener(this);

        
        // Create header for the window.
        String headerText = "Username: Name, Project: Name's Project";
        JPanel headerPanel = new JPanel();
        headerPanel.setSize(10, 10);
        headerPanel.setLocation(0, 0);
        JLabel headerLabel = new JLabel(headerText);
        headerPanel.add(headerLabel);

        
        panel.setJMenuBar(jmb);
        panel.add(headerPanel);
        panel.setVisible(true);
    }
    

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        System.out.println(comStr + " Selected");
        
        // If Exit is selected then close the window.
        if(comStr.equals("Exit")){
            System.exit(0);
        }
    }
        
        


    /**
     * Abstract method from observer
     * From the API
     *      - Observable is the Observable object.
     *      - arg is the argument passed to the notifyObservers method.
     * 
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {

    }
}
