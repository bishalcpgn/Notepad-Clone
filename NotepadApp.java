
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

// Main class 
class NotepadApp extends JFrame {

    // Initializing Menus and menubar
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    // Initializing Menu Items for File menu
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem printFile = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");

    // Initializing Menu Items for Edit menu
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectAllText = new JMenuItem("Select All");

    // Initializing Menu Items for Help menu
    JMenuItem about = new JMenuItem("About");

    // Initializing Text area
    JTextArea textArea = new JTextArea();

    // Constructor of NotepadApp class
    NotepadApp() {

        setTitle("Notepad");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding MenuItems in File menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(exit);

        // Adding MenuItems in Edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAllText);

        // Adding MenuItems to Help menu
        help.add(about);

        // Adding Menus into Menubar
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        // Adding MenuBar in frame
        setJMenuBar(menubar);

        // Text Area with scroll pane
        textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        // Adding line wrap
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // To add bars
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        // Changing horizontal and vertical bar policy
        textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(textAreaScrollPane);

        // Adding Event handling to submenus using annonymous class
        newFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textArea.setText(null);
            }
        });
        
        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JFileChooser chooseFile = new JFileChooser();
                // Disabling all other file extension
                chooseFile.setAcceptAllFileFilterUsed(false);
                // Allowing txt extension as choosable
                FileNameExtensionFilter allowExtension = new FileNameExtensionFilter("Text File", "txt");
                chooseFile.addChoosableFileFilter(allowExtension);
                // Checking the buttons clicked
                int response = chooseFile.showOpenDialog(null);
                // Response can be 0 or 1
                // can be checked with 0 or 1 also
                if (response == JFileChooser.APPROVE_OPTION) {
                    // Getting file path
                    File fileToBeOpened = new File(chooseFile.getSelectedFile().getAbsolutePath());
                    // Reading file data
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileToBeOpened));
                        textArea.read(reader, textAreaScrollPane);
                        reader.close();
                    } catch (Exception e) {
                        // Contribute catch part by PR

                    }
                }
            }
        });

        saveFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JFileChooser saveFile = new JFileChooser();
                // Disabling all other file extension
                saveFile.setAcceptAllFileFilterUsed(false);
                // Allowing txt extension as choosable
                FileNameExtensionFilter allowExtension = new FileNameExtensionFilter("Text File", "txt");
                saveFile.addChoosableFileFilter(allowExtension);
                // Checking the buttons clicked
                int response = saveFile.showSaveDialog(null);
                // Response can be 0 or 1
                // can be checked with 0 or 1 also
                if (response == JFileChooser.APPROVE_OPTION) {
                    // Getting file path
                    File fileToBeOpened = new File(saveFile.getSelectedFile().getAbsolutePath());
                    // Reading file data
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileToBeOpened));
                        textArea.write(writer);
                        writer.close();
                    } catch (Exception e) {

                        // Contribute catch part by PR
                    }
                }
            }
        });


        printFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    textArea.print();
                } catch (Exception e) {

                    // Contribute catch part by PR

                }

            }
        });


        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });


        cut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textArea.cut();
            }
        });


        copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textArea.copy();
            }
        });


        paste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textArea.paste();
            }
        });


        selectAllText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textArea.selectAll();
            }
        });


        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                new AboutDialogueBox();
            }
        });


        // Adding keyboard shortcuts
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        printFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        selectAllText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));


        // Making frame visible
        setVisible(true);

    }

    // Main method
    public static void main(String[] args) {

        new NotepadApp();

    }

}

// class for About submenu 
class AboutDialogueBox extends JFrame {

    // Constructor of AboutDialogueBox class
    AboutDialogueBox() {
        setTitle("About");
        setLayout(null);
        setBounds(300, 200, 400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add image
        // Image will be shown blank 
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(""));
        imageLabel.setBounds(170, 50, 70, 70);
        add(imageLabel);

        // Adding text
        JLabel textLabel = new JLabel("<html>This is a notepad app.<br>Credits : @bishalcpgn </html>");
        textLabel.setFont(new Font("arial", Font.PLAIN, 12));
        textLabel.setBounds(150, 120, 200, 80);
        add(textLabel);

        setVisible(true);
    }
}
