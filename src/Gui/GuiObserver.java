/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.CardLayout;
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
import javax.swing.BoxLayout;
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
    private CardLayout cl = new CardLayout();
    private JPanel bottomPanel;
    private JPanel headerPanel;
    
    public GuiObserver(){
        super("Initial Title");
        initialize();        
    }
    
    //Doesn't have to be called initialize.  Could be named anything.
    private void initialize(){
        // http://www.java2s.com/Code/Java/Swing-JFC/Createamainmenu.htm
        
        // Setting up the main panel.
        JFrame panel = new JFrame(userOutput.getString("title_text"));
        // Create box layout so two panels can be displayed.        
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(600, 500);
        // Centering panel on the screen.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setLocation(dim.width/2-panel.getSize().width/2, dim.height/2-panel.getSize().height/2);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crating a menu bar
        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu(userOutput.getString("display_menu"));
        JMenuItem jmiETR = new JMenuItem(userOutput.getString("menu_time_record"));
        JMenuItem jmiLogOut = new JMenuItem(userOutput.getString("menu_exit"));
        JMenuItem jmiExit = new JMenuItem(userOutput.getString("exit_program_message"));
        jmFile.add(jmiETR);
        jmFile.addSeparator();
        jmFile.add(jmiLogOut);
        jmFile.add(jmiExit);
        jmb.add(jmFile);
        JMenu jmHelp = new JMenu(userOutput.getString("help_menu_item"));
        JMenuItem jmiAbout = new JMenuItem(userOutput.getString("about_menu_item"));
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        // Adding actionListeneras to buttons
        jmiETR.addActionListener(this);
        jmiLogOut.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiAbout.addActionListener(this);
        //GUIMaster.table.addMouseListener(new java.awt.event.MouseAdapter() {
            
        //}

        // Create header for the window.
        //String headerText = "Username: Name, Project: Name's Project";
        headerPanel = new JPanel();
        //headerPanel.setSize(10, 10);
        headerPanel.setSize(600,20);
        headerPanel.setLocation(0, 0);
        JLabel headerLabel = new JLabel(userOutput.getString("display_header"));
        headerPanel.add(headerLabel);

        // Create a bottom panel for displaying CardLayout panels
        bottomPanel = new JPanel();
        bottomPanel.setLayout(cl);
        // Add log on panel asking for the username and password.
        // Create blank panel for initial loading
        JPanel blankPanel = new JPanel();
        //blankPanel.setLocation(0, 20);
        String blankText = " "; 
        JLabel blankLabel = new JLabel(blankText);
        blankPanel.add(blankLabel);
        // Add blank panel to container.
        bottomPanel.add(blankPanel, "1");
        // Create Enter Time Record panel.
        JPanel createTimeRecordPanel = new JPanel();
        //createTimeRecordPanel.setLocation(0, 20);
        String temporaryText = "Here is where our output will go for creating the time record panel.";  //Remove this later.
        JLabel temporaryLabel = new JLabel(temporaryText);  // Remove this later.
        createTimeRecordPanel.add(temporaryLabel); // Remove this later.
        // Add create time record panel to container.
        bottomPanel.add(createTimeRecordPanel, "2");
        // Tell bottom panel to show the blank panel initially.
        cl.show(bottomPanel, "1");
        // Setting the menu bar
        panel.setJMenuBar(jmb);
        // Adding bottom panel that will be changed out to the header panel.
        headerPanel.add(bottomPanel);
        // Adding the header panel
        panel.add(headerPanel);
        // Making the panel visible.
        panel.setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        System.out.println(comStr + " Selected");
        
        // If Exit is selected then close the window.
        if(comStr.equals(userOutput.getString("exit_program_message"))){
            System.exit(0);
        } else if(comStr.equals(userOutput.getString("menu_time_record"))) {
            cl.show(bottomPanel, "2");
        } else if(comStr.equals(userOutput.getString("menu_exit"))) {
            cl.show(bottomPanel, "1");
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
