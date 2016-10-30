/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2;

import TimeKeeper.Authentication;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Eric Walton
 */
public class GUIMaster extends JFrame implements Observer, ActionListener, ComponentListener {

    String bundleName = "Gui.TimeKeeper";
    ResourceBundle userOutput = ResourceBundle.getBundle(bundleName, Locale.ENGLISH);
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 700;
    private static final int FRAME_LOCATON_X = 300;
    private static final int FRAME_LOCATON_Y = 100;
    // outlets for welcome header
    private static JLabel welcomeLabel;
    // outlets for signIn Panel
    private static JLabel usernameLabel;
    private static JTextField usernameField;
    private static JLabel passwordLabel;
    private static JPasswordField passwordField;
    // outlets for footer panel
    private static JLabel footerLabel;
    // frame
    private static JFrame frame;
    // panels 
    private static JPanel welcomePanel;
    private static JPanel signInPanel;
    private static JPanel enterTimeRecordPanel;
    private static JPanel footerPanel;
    private static JTable table;
    private static Container container1;

    private static final String USERNAME_TEXT = "Username";
    private static final String PASSWORD_TEXT = "Password";

    public GUIMaster() {
        frameSetup();
    }

    /**
     * frame setup
     */
    public void frameSetup() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Time Keeper");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocation(FRAME_LOCATON_X, FRAME_LOCATON_Y);
        frame.addComponentListener(this);
        welcomePanel();
        frame.add(welcomePanel);
        signInPanel();
        frame.add(signInPanel);
        menu();// calls the method to setup the menu
        footer();
        enterTimeRecordPanel();
        frame.setVisible(true);

    }

    private JMenuBar jmb = new JMenuBar();

    /**
     * Menu setup
     */
    public void menu() {
        // Crating a menu bar
        //JMenuBar jmb = new JMenuBar();
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
        // Setting the menu bar
        //frame.setJMenuBar(jmb);

        // Adding actionListeneras to buttons
        jmiETR.addActionListener(this);
        jmiLogOut.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiAbout.addActionListener(this);
    }

    /**
     * Welcome panel setup
     */
    public void welcomePanel() {
        welcomePanel = new JPanel();
        welcomePanel.setLocation(0, 0);
        welcomePanel.setSize(frame.getBounds().width, 40);
        welcomePanel.setBackground(Color.blue);
        welcomeLabel = new JLabel(userOutput.getString("program_greeting"));
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
        welcomePanel.add(welcomeLabel);
    }

    /**
     * signIn panel setup
     */
    public void signInPanel() {
        signInPanel = new JPanel(new GridBagLayout());
        signInPanel.setBackground(Color.lightGray);
        signInPanel.setLocation(0, 40);
        signInPanel.setSize(frame.getBounds().width, 60);
        JButton enterButton = new JButton("enter");
        enterButton.addActionListener(this);
        usernameLabel = new JLabel(USERNAME_TEXT);
        usernameLabel.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
        usernameField = new JTextField(20);
        passwordLabel = new JLabel(PASSWORD_TEXT);
        passwordLabel.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');

        // setting up GridBagConstraints for signInPanel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.PAGE_START;

        c.gridx = 0;
        c.gridy = 0;
        signInPanel.add(usernameLabel, c);
        c.gridx = 3;
        c.gridy = 0;
        signInPanel.add(passwordLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        signInPanel.add(usernameField, c);
        c.gridx = 3;
        c.gridy = 1;
        signInPanel.add(passwordField, c);
        c.gridx = 4;
        c.gridy = 1;
        signInPanel.add(enterButton, c);
    }// end of signInPanel

    // will build project list record panel here
    // All display panels will be built with same x and y of signInPanel and swapped between hidden and shown
    private void enterTimeRecordPanel() {
        // planning to use JTable to present projects unless team has other suggestions.
        enterTimeRecordPanel = new JPanel(new GridBagLayout());
        enterTimeRecordPanel.setLocation(0, 40);
        // size set in updatePanelBounds
        table = new JTable(new TableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 170));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        table.getColumnModel().getSelectionModel();
        table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        //This sorts the table by clicking on the columns names
        table.setAutoCreateRowSorter(true);
        // this is how we justify the project Id column
        table.getColumnModel().getColumn(0).setCellRenderer(new RenderID());
//        ButtonGroup bGroup = new ButtonGroup();
//        JRadioButton startRButton = new JRadioButton("Start", false);
//        JRadioButton endRButton = new JRadioButton("End", false);
//        bGroup.add(startRButton);
//        bGroup.add(endRButton);
        JButton createRecordButton = new JButton("Create Start Record");
        // setting up GridBagConstraints for signInPanel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.PAGE_START;

//        c.gridwidth = 0;
//        c.gridx = 0;
//        c.gridy = 0;
//        enterTimeRecordPanel.add(table.getTableHeader(),c);
        c.gridheight = 3;
        c.gridx = 0;
        c.gridy = 0;
        enterTimeRecordPanel.add(scrollPane, c);

        c.gridheight = 1;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 0;
        enterTimeRecordPanel.add(createRecordButton, c);
        enterTimeRecordPanel.setBackground(Color.LIGHT_GRAY);
        frame.add(enterTimeRecordPanel);
        enterTimeRecordPanel.setVisible(false);
    }

    /**
     * Footer setup
     */
    public void footer() {
        footerPanel = new JPanel();
        // footer location is set in updatePanelBounds
        footerPanel.setSize(frame.getBounds().width, 40);
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerLabel = new JLabel(userOutput.getString("first_name_or_exit"));
        footerLabel.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
        footerPanel.setForeground(Color.BLACK);
        footerPanel.add(footerLabel);
        frame.add(footerPanel);
    }

    /**
     * Change Footer label to needed output
     *
     * @param output
     */
    public void setFooterText(String output) {
        footerLabel.setText(userOutput.getString(output));
    }

    /**
     *
     * @param width
     */
    public void updatePanelBounds(int width) {
        welcomePanel.setSize(width, welcomePanel.getSize().height);
        signInPanel.setSize(width, signInPanel.getSize().height);
        footerPanel.setLocation(0, (int) frame.getHeight() - footerPanel.getSize().height - 40);
        footerPanel.setSize(width, footerPanel.getSize().height);
        enterTimeRecordPanel.setSize(frame.getBounds().width, 200);
    }

    public void preValidateSignIn() {

        if (usernameField.getText().isEmpty()) {
            setFooterText("invalid_first_name");// would like to suggest invalid user name instead of first name
        } else if (passwordField.getText().isEmpty()) {
            setFooterText("invalid_password");
        } else {
            // set user name here 
            setFooterText("verify_password");
            // will call function to validate signIn
        }

    }

    /**
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * actionPerformed
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Enter".equals(command)) {
            preValidateSignIn();
        }

        // If Exit is selected then close the window.
        if (command.equals(userOutput.getString("exit_program_message"))) {
            System.exit(0);
        } else if (command.equals(userOutput.getString("menu_time_record"))) {
            signInPanel.setVisible(false);// hides the signin panel
            enterTimeRecordPanel.setVisible(true);
            setFooterText("menu_time_record");
            // need to show the enter time record panel when it's built   
        } else if (command.equals(userOutput.getString("menu_exit"))) {// maybe change menu_exit to logout?
            signInPanel.setVisible(true);// shows the signInPanel 
            enterTimeRecordPanel.setVisible(false);
            frame.setJMenuBar(null);
            setFooterText("first_name_or_exit");
        } else if (command.equals(userOutput.getString("enter"))) {// maybe change menu_exit to logout?
            if (Authentication.authenticateUser(usernameField.getText(), passwordField.getText())) {
                signInPanel.setVisible(false);// shows the signInPanel 
                setFooterText("title_text");
                frame.setJMenuBar(jmb);
                usernameField.setText("");
                passwordField.setText("");
            } else {
                usernameField.setText("");
                passwordField.setText("");
                setFooterText("invalid_password");
            }
        }

    }// end of action perfromed

    /**
     * Component resized
     *
     * @param e
     */
    @Override
    public void componentResized(ComponentEvent e) {
        int width = e.getComponent().getSize().width; // gets resized componets width
        int height = e.getComponent().getSize().height;// gets the resized components height
        updatePanelBounds(width); // calls custom method that updates the panels bounds
        if (enterTimeRecordPanel.isVisible() == true) {
            if (width < 700) {// sets the minimum width of frame and panels
                frame.setSize(700, height);
                updatePanelBounds(frame.getBounds().width);
            }
            if (height < 324) {// sets the mininmum height of frame and panels
                frame.setSize(width, 324);
            }
        } else if (signInPanel.isVisible() == true) {// end if enterTimeRecordPanel visible
            if (width < 700) {// sets the minimum width of frame and panels
                frame.setSize(700, height);
                updatePanelBounds(frame.getBounds().width);
            }
            if (height < 180) {// sets the mininmum height of frame and panels
                frame.setSize(width, 180);
            }
        }
    }// end componentResized

    /**
     * componentMoved
     *
     * @param e
     */
    @Override
    public void componentMoved(ComponentEvent e) {

    }

    /**
     * componentShown
     *
     * @param e
     */
    @Override
    public void componentShown(ComponentEvent e) {

    }

    /**
     * componentHidden
     *
     * @param e
     */
    @Override
    public void componentHidden(ComponentEvent e) {

    }

}// end of class
