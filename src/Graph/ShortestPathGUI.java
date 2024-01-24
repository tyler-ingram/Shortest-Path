package Graph;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        MSTGUI.java
 * Description  A class representing the GUI used in the Minimum Spanning Tree
 *              Application. This program reads data from text files and builds
 *              a graph for which a MST is displayed with total weigh.
 *              WeightedGraphSample1.txt has ABQ as vertex #12 with appropriate
 *              diatance from Seattle, Boston and Dallas.
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 143
 * Hourse       4 hours and 17 minutes
 * Date         11/28/2022
 * History Log  
 * @author	<i>Tyler Ingram</i>
 * @version 	%1% %2%
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit 
 * TODO: 1. write public StringBuffer displayWeightedEdges() in Weighted edges
 *       2. write public StringBuffer printTree(StringBuffer out) in AbstractGraph
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class ShortestPathGUI extends javax.swing.JFrame
{
    private String fileName = "src/Graph/WeightedGraphSample.txt";
    private String citiesFile = "src/Graph/Cities.txt";
    private StringBuffer output = new StringBuffer();
    private List<WeightedEdge> edges;
    private int[][]edgeArray;
    private WeightedGraph<String> graph;
    private int numberOfVertices = 0;
    private String[]citiesArray;
    private boolean isConnected = false;
    private int startingCity;
    private int endingCity;
    private List<String> cities;
    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  ShortestPathGUI()-default constructor
     * Description  Create an instance of the GUI form, set icon image, set
     *              default button, and instantiate list and graph.
     * Date         11/28/2022
     * History Log  
     * @author      <i>Tyler Ingram</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public ShortestPathGUI()
    {
        initComponents();
        //set image
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/Cities_small.png"));
        //set default button
        this.getRootPane().setDefaultButton(goJButton);    
//        cities = new ArrayList<>();
////        graph = new WeightedGraph<>(edges,numberOfVertices);
        saveJMenuItem.setEnabled(false);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       readFromFile()
     * Description  Read text file and create ArrayList.
     * Date:        4/23/2019
     * @author      <i>Tyler Ingram</i>
     * @param       textFile String
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void readFromFile(String fileName,String citiesFile)
    {
        try
        {
            //to read the cities 
            File citiesF = new File(citiesFile);
            //to read the vertices
            File file = new File(fileName);
            Scanner citiesIn = new Scanner (citiesF);
            Scanner inFile = new Scanner(file);
            cities = new ArrayList<>();
            edges = new java.util.ArrayList();
            //read the first line in the file which is the number of nodes
            String line = inFile.nextLine();
            numberOfVertices = Integer.parseInt(line);
            citiesArray= new String[numberOfVertices];
            //make the edge array with enough slots for the max number of connections
            int[][] edgesArray=new int[numberOfVertices*(numberOfVertices-1)][3]; 
            //create an array list of edges 
            int index = 0;
            while(inFile.hasNext())
            {
                
                line = inFile.nextLine();
                //Split line at |
                String[] triplets = line.split("[\\|]");
                
                for(String triplet: triplets)
                {
                    String[] tokens = triplet.split("[,]");
                    int u = Integer.parseInt(tokens[0].trim());
                    int v = Integer.parseInt(tokens[1].trim());
                    int w = Integer.parseInt(tokens[2].trim());
                    //undirected so it goes both ways
                    edgesArray[index][0] = u;
                    edgesArray[index][1] = v;
                    edgesArray[index][2]=w;
                    index++;
                    //to make it two sided
                    edgesArray[index][0]=v;
                    edgesArray[index][1]=u;
                    edgesArray[index][2]=w;
                    //undirected graph so add both ways
                    edges.add(new WeightedEdge(u,v,w));
                    edges.add(new WeightedEdge(v,u,w));
                    index++;
                } 
            }
            edgeArray = new int[index][3];
            //copy the array into one that fits
            for(int i = 0; i < index; i ++)
                {
                    for(int k = 0; k < 3; k++)
                    {
                        edgeArray[i][k] = edgesArray[i][k];
                    }
                }
            for(int i = 0; i < numberOfVertices; i ++)
            {
                //add the city to the array list
//                cities.add(citiesIn.nextLine());
                citiesArray[i]= citiesIn.nextLine();
            }
        }  
        catch(FileNotFoundException fnfexp)
        {
//            fnfexp.printStackTrace();
            JOptionPane.showMessageDialog(null, "Input error -- File not found.",
                    "File Not Found Error!", JOptionPane.ERROR_MESSAGE);
        }        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        fileJLabel = new javax.swing.JLabel();
        filesJComboBox = new javax.swing.JComboBox<>();
        controlJPanel = new javax.swing.JPanel();
        goJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        resultsScrollPane = new javax.swing.JScrollPane();
        resultsJTextArea = new javax.swing.JTextArea();
        cityJPanel = new javax.swing.JPanel();
        startJLabel = new javax.swing.JLabel();
        startJTextField = new javax.swing.JTextField();
        endJLabel = new javax.swing.JLabel();
        endJTextField = new javax.swing.JTextField();
        showGraphJButton = new javax.swing.JButton();
        personJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        newJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        printMenuItem = new javax.swing.JMenuItem();
        showPictureOfGraphsJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shortest Path Tree");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 48)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cities_small.png"))); // NOI18N
        titleJLabel.setText("Shortest Path Tree");

        fileJLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fileJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fileJLabel.setText("Select File:");

        filesJComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        filesJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WeightedGraphSample", "WeightedGraphSample1" }));

        controlJPanel.setLayout(new java.awt.GridLayout(1, 2, 3, 3));

        goJButton.setBackground(new java.awt.Color(255, 255, 204));
        goJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        goJButton.setMnemonic('g');
        goJButton.setText("Go");
        goJButton.setToolTipText("Show results");
        goJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(goJButton);

        quitJButton.setBackground(new java.awt.Color(255, 255, 204));
        quitJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.setToolTipText("End the Application");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(quitJButton);

        resultsJTextArea.setEditable(false);
        resultsJTextArea.setBackground(new java.awt.Color(240, 240, 240));
        resultsJTextArea.setColumns(20);
        resultsJTextArea.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        resultsJTextArea.setLineWrap(true);
        resultsJTextArea.setRows(5);
        resultsJTextArea.setToolTipText("Show the results of the path. If you need ideas for cities click the View Graph Button");
        resultsJTextArea.setWrapStyleWord(true);
        resultsScrollPane.setViewportView(resultsJTextArea);

        cityJPanel.setLayout(new java.awt.GridLayout(2, 2));

        startJLabel.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        startJLabel.setText("Starting  City:");
        cityJPanel.add(startJLabel);

        startJTextField.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        startJTextField.setToolTipText("Enter the starting city spelled correctly (Not case sensitive)");
        cityJPanel.add(startJTextField);

        endJLabel.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        endJLabel.setText("Ending City:");
        cityJPanel.add(endJLabel);

        endJTextField.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        endJTextField.setToolTipText("Enter the ending city spelled correctly (Not case sensitive)");
        cityJPanel.add(endJTextField);

        showGraphJButton.setBackground(new java.awt.Color(255, 255, 204));
        showGraphJButton.setText("View Graph");
        showGraphJButton.setToolTipText("View the graph of the current cities list");
        showGraphJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphJButtonActionPerformed(evt);
            }
        });

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        newJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newJMenuItem.setMnemonic('N');
        newJMenuItem.setText("New");
        newJMenuItem.setToolTipText("Load new set of cities");
        newJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(newJMenuItem);

        clearJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        clearJMenuItem.setMnemonic('R');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear the results and cities picked");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printMenuItem.setMnemonic('P');
        printMenuItem.setText("Print Form");
        printMenuItem.setToolTipText("Print Form as GUI");
        printMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printMenuItem);

        showPictureOfGraphsJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        showPictureOfGraphsJMenuItem.setMnemonic('h');
        showPictureOfGraphsJMenuItem.setText("Show Graph");
        showPictureOfGraphsJMenuItem.setToolTipText("Show pictures of graph");
        showPictureOfGraphsJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPictureOfGraphsJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(showPictureOfGraphsJMenuItem);

        saveJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save");
        saveJMenuItem.setToolTipText("Save the shortest path to an external text file");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);
        fileJMenu.add(fileJSeparator);

        quitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.setToolTipText("");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        personJMenuBar.add(fileJMenu);

        helpMenu.setMnemonic('H');
        helpMenu.setText("Help");

        aboutJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("Show About form");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutJMenuItem);

        personJMenuBar.add(helpMenu);

        setJMenuBar(personJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(fileJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filesJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(titleJLabel)
                        .addGap(38, 38, 38)
                        .addComponent(showGraphJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleJLabel)
                    .addComponent(showGraphJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filesJComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fileJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       printJMenuItemActionPerformed()
     * Description  Event handler to print the for as a GUI. Calls the
     *              PrintUtilities class static printComponent method.
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  7/18/2018, 11/28/2022
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_printMenuItemActionPerformed
    {//GEN-HEADEREND:event_printMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printMenuItemActionPerformed
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       quitJMenuItemActionPerformed()
     * Description  Event handler to end the application. Calls the quitJButton
     *              doClick event handler,
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitJMenuItemActionPerformed
    {//GEN-HEADEREND:event_quitJMenuItemActionPerformed
        quitJButton.doClick();
    }//GEN-LAST:event_quitJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       aboutJMenuItemActionPerformed()
     * Description  Create an About form and show it. 
     * @param       evt java.awt.event.KeyEvent
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aboutJMenuItemActionPerformed
    {//GEN-HEADEREND:event_aboutJMenuItemActionPerformed
        About aboutWindow = new About(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       newJMenuItemActionPerformed
     * Description  Event handler to chose a separate file for a graph. Also
     *              calls readFromFile and createGraph methods.
     * @param       evt java.awt.event.KeyEvent
     * @author      <i>Tyler Ingram</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void newJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newJMenuItemActionPerformed
    {//GEN-HEADEREND:event_newJMenuItemActionPerformed
        try
        {
            String verticesFile = "";
            JFileChooser chooser = new JFileChooser("src/Graph");
            //Filter only txt files
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Txt Files", "txt");
            chooser.setFileFilter(filter);
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION)
            {
                File chosenFile = chooser.getSelectedFile();
                fileName = "src/Graph/" + chosenFile.getName();
                //take the number at the end of the cities file and choose that file in the combo box
                if(chosenFile.getName().endsWith("s.txt"))      
                verticesFile = "src/Graph/WeightedGraphSample";
                else
                    verticesFile = "src/Graph/WeightedGraphSample" + 
                        chosenFile.getName().charAt(chosenFile.getName().length()-5);
                //select the right vertices file
                filesJComboBox.setSelectedItem(verticesFile.substring(verticesFile.lastIndexOf("/")+1));
                //read the files and the cities
                readFromFile(verticesFile + ".txt",fileName); 
//                createGraph();  //dynamically decide if connected
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cannot find file",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(java.lang.IllegalArgumentException exp)
        {
            JOptionPane.showMessageDialog(null, "File is not in correct format.",
                "File Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_newJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       quitJButtonActionPerformed()
     * Description  Event handler to end the application.
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitJButtonActionPerformed
    {//GEN-HEADEREND:event_quitJButtonActionPerformed
        System.exit(0);        
    }//GEN-LAST:event_quitJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       goJButtonActionPerformed()
     * Description  Event handler to end the application.
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void goJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_goJButtonActionPerformed
    {//GEN-HEADEREND:event_goJButtonActionPerformed
        try
        {
            if(startJTextField.getText()== null || startJTextField.getText().equals(""))
                throw new IllegalArgumentException("Please fill out starting city");
            if(endJTextField.getText()== null || endJTextField.getText().equals(""))
                throw new IllegalArgumentException("Please fill out ending city");
            resultsJTextArea.setText("");
            output = new StringBuffer();
            String fileComboBox = filesJComboBox.getSelectedItem().toString();
            //set the vertex file and the cities files
            fileName = "src/Graph/" + fileComboBox + ".txt";
            //add the number to the cities file if it is on the vertex file to match
            if(filesJComboBox.getSelectedIndex()==0)
            citiesFile = "src/Graph/Cities.txt";
            else
                citiesFile = "src/Graph/Cities" + 
                        fileComboBox.charAt(fileComboBox.length()-1) + ".txt";
            readFromFile(fileName,citiesFile);             
            if(citiesExist(startJTextField.getText(),endJTextField.getText()))
            {
            if(startJTextField.getText()!= null && endJTextField.getText()!= null)
            {
                startingCity = Arrays.asList(citiesArray).indexOf(startJTextField.getText());
                endingCity = Arrays.asList(citiesArray).indexOf(endJTextField.getText());
            }
            
            
            createGraph();      //create the graph and decide if connected
            }
        }
        catch(IllegalArgumentException ex)
        {
//            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Cannot create graph, Enter a correct city in the graph.", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            JOptionPane.showMessageDialog(null, exp.getMessage(),
                "Cannot create graph", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_goJButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       clearJMenuItemActionPerformed()
     * Description  Event handler to clear the fields and results
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        resultsJTextArea.setText("");
        startJTextField.setText("");
        endJTextField.setText("");
        saveJMenuItem.setEnabled(false);
    }//GEN-LAST:event_clearJMenuItemActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       saveJMenuItemActionPerformed()
     * Description  Event handler to save the path to a external file
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        try
        {
        File outFile = new File("Src/Graph/Path.txt");
        
        PrintWriter pw = new PrintWriter(outFile);
        String output = resultsJTextArea.getText();
        pw.write(output.toString());
        pw.close();
        }
        catch(FileNotFoundException fnfEx)
        {
            JOptionPane.showMessageDialog(null, "Save Error", "Error saving to file", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveJMenuItemActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       showPictureOfGraphsJMenuItemActionPerformed()
     * Description  Shows the picture of the graph in another form
     * @author      <i>Tyler Ingram</i>
     * @return      boolean if the cities exist
     * @param       evt java.awt.event.ActionEvent
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void showPictureOfGraphsJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPictureOfGraphsJMenuItemActionPerformed
        if(filesJComboBox.getSelectedIndex()==0)
            new ShowGraphs(this,true,"src/Images/WeightedGraphSample0.png").setVisible(true);
        else
            new ShowGraphs(this,true,"src/Images/"+ filesJComboBox.getSelectedItem()
        +".png").setVisible(true);
    }//GEN-LAST:event_showPictureOfGraphsJMenuItemActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       showPictureOfGraphsJMenuItemActionPerformed()
     * Description  Shows the picture of the graph in another form
     * @author      <i>Tyler Ingram</i>
     * @return      boolean if the cities exist
     * @param       evt java.awt.event.ActionEvent
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void showGraphJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphJButtonActionPerformed
        showPictureOfGraphsJMenuItemActionPerformed(evt);
    }//GEN-LAST:event_showGraphJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       citiesExist()
     * Description  Check to see if the starting and ending cities exist
     * @author      <i>Tyler Ingram</i>
     * @return      boolean if the cities exist
     * @param       start the starting city as a string
     * @param       end the ending city as a string
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private boolean citiesExist (String start, String end) 
    {
        boolean startExists = false;
        boolean endExists = false;
        //loop to test if the cities exist as part of the file 
        for (int i = 0; i < numberOfVertices; i ++)
        { 
            if(citiesArray[i].equalsIgnoreCase(start))
                startExists = true;
            if(citiesArray[i].equalsIgnoreCase(end))
                endExists = true;
        }
        if(startExists && endExists)
            return startExists &&endExists;
        else
            throw new IllegalArgumentException();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       createGraph()
     * Description  Created UnweightedGraph and associated tree and decide if
     *              the graph is connected.
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void createGraph()
    {
        resultsJTextArea.setText("");
        output = new StringBuffer();
        //construct graph
        //graph = new WeightedGraph(edges,numberOfVertices);
        
//        output.append("The number of vertices is " + numberOfVertices + "\n\n");
        
        WeightedGraph<String> graph = new WeightedGraph<String>(citiesArray,edgeArray);
        WeightedGraph<String>.ShortestPathTree tree = graph.getShortestPath(endingCity);
        List<String> path = tree.getPath(startingCity);
        output.append("The shortest path from " + citiesArray[startingCity] + 
                " to " + citiesArray[endingCity] + " is:\n");
        for(String s: path)
            output.append(s.toString() + " ->");
        output.delete(output.length()-3, output.length());
        
        output.append("\nTotal weight of path is " + tree.getCost(startingCity));
        
//        output.append("\nThe shortest path from " + cities.get(startingCity) + 
//                " to " + cities.get(endingCity) + " is:\n" + 
//                tree.printPath(startingCity));
        resultsJTextArea.setText(output.toString());
        saveJMenuItem.setEnabled(true);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       translatePath()
     * Description  Translates the path from vertices to cities.
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
//    private String translatePath(StringBuffer out)
//    {
//        String output = "";
//        for(int i = 0; i < out.length(); i ++)
//        {
//            output += cities.get(out.charAt(i)) + " ->";
//        }
//        return output;
//    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
     * Method       main()
     * Description  Displays splash screen and the main GUI form.
     * @param       args are the command line strings
     * @author      <i>Tyler Ingram</i>
     * Date         11/28/2022
     * History Log  
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[])
    {
        // Show splash screen
        Splash mySplash = new Splash(4000);     // duration = 5 seconds
        mySplash.showSplash();                  // show splash screen  
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ShortestPathGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ShortestPathGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ShortestPathGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ShortestPathGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ShortestPathGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JPanel cityJPanel;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JLabel endJLabel;
    private javax.swing.JTextField endJTextField;
    private javax.swing.JLabel fileJLabel;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JComboBox<String> filesJComboBox;
    private javax.swing.JButton goJButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem newJMenuItem;
    private javax.swing.JMenuBar personJMenuBar;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JTextArea resultsJTextArea;
    private javax.swing.JScrollPane resultsScrollPane;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JButton showGraphJButton;
    private javax.swing.JMenuItem showPictureOfGraphsJMenuItem;
    private javax.swing.JLabel startJLabel;
    private javax.swing.JTextField startJTextField;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
