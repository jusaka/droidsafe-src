/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

//This code was copied from Sun tutorial initially

package droidsafe.gui;

/*
 * This code is based on an example provided by Richard Stanford, 
 * a tutorial reader.
 */

import droidsafe.gui.FileTypeDetector;
import droidsafe.gui.FileTypeDetector.FileType;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallTraceViewer extends JPanel 
                             implements ActionListener {
    private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
    private static String LOAD_COMMAND = "load";
    
    private DynamicTree treePanel;  //panel to hold tree
    private CallTree callTree;
    
    private static Logger logger = LoggerFactory.getLogger(CallTraceViewer.class);

    public CallTraceViewer() {
        super(new BorderLayout());
        
        callTree = new CallTree();
        
        //Create the components.
        treePanel = new DynamicTree();
        populateTree(treePanel);

        JButton addButton = new JButton("Add");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);
        addButton.setEnabled(false);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);
        removeButton.setEnabled(false);
        
        JButton clearButton = new JButton("Clear");
        clearButton.setActionCommand(CLEAR_COMMAND);
        clearButton.addActionListener(this);
        clearButton.setEnabled(false);

        JButton loadButton = new JButton("Load");
        loadButton.setActionCommand(LOAD_COMMAND);
        loadButton.addActionListener(this);

        //Lay everything out.
        treePanel.setPreferredSize(new Dimension(900, 600)); 
       
        add(treePanel, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0,4));
        panel.add(loadButton);
        panel.add(addButton);
        panel.add(removeButton); 
        panel.add(clearButton);
        add(panel, BorderLayout.SOUTH);
        panel = new JPanel();
        panel.add(new JLabel("Use Load to load logcat.txt and classification fie, separately"));
        add(panel, BorderLayout.NORTH);
    }

    public void populateTree(DynamicTree treePanel) {
        String p1Name = new String("Parent 1");
        String c1Name = new String("Child 1");
        String c2Name = new String("Child 2");

        DefaultMutableTreeNode p1;

        p1 = treePanel.addObject(null, p1Name);

        treePanel.addObject(p1, c1Name);
        treePanel.addObject(p1, c2Name);

    }
        
    
    private void loadFromFile() {
        
        String dir = "./";
        String apacDir = System.getenv("ANDROID_SRC_HOME");
        if (apacDir != null) {
            dir = apacDir + "/android-apps";
        }
        
        final JFileChooser fc = new JFileChooser(dir);
        Dimension dialogDim = new Dimension(800, 400);
        fc.setSize(dialogDim);
        fc.setPreferredSize(dialogDim);
        int returnValue = fc.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
           
            File selectedFile = fc.getSelectedFile();
            List<String> lines = null;
            try {
                lines = IOUtils.readLines(new FileInputStream(selectedFile));
            }
            catch (Exception ex) {
                return;
            }
            
            switch (FileTypeDetector.v().getFileType(lines)) {
                case CALLTRACE: 
                    {
                        callTree.loadLines(lines);
                        logger.info("Dumping Tree {}", callTree);
                        treePanel.populateTree(callTree);                    
                    }
                break;
                    
                case CLASSIFCATION:
                {
                    ApiClassifier.v().loadLines(lines);
                }
                break;
                    
                default:
                    break;
            }

        }
        
    }
   
    ///////////////////////////////////////////////////////////////////////////
    //              main() and Event handling methods
    ///////////////////////////////////////////////////////////////////////////
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
            treePanel.addObject("New Node " + newNodeSuffix++);
        } else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            treePanel.removeCurrentNode();
        } else if (CLEAR_COMMAND.equals(command)) {
            //Clear button clicked.
            treePanel.clear();
        } else if (LOAD_COMMAND.equals(command)) {
            //Clear button clicked.
            loadFromFile();;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Droidsafe CallTreeViewier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CallTraceViewer newContentPane = new CallTraceViewer();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
