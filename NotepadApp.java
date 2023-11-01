
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.Font;
import javax.swing.ImageIcon;


class NotepadApp extends JFrame  {

    // Initializing Menus and menubar 
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    // Initializing Menu Items for File menu 
    JMenuItem newFile =new JMenuItem("New");
    JMenuItem openFile =new JMenuItem("Open");
    JMenuItem saveFile =new JMenuItem("Save");
    JMenuItem printFile =new JMenuItem("Print");
    JMenuItem exit =new JMenuItem("Exit");

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
        setBounds(100,100,800,600);
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
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        // Adding line wrap 
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        // Changing horizontal and vertical bar policy 
        textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(textAreaScrollPane);

        
    // Adding Event handling using annonymous class    
    newFile.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
            textArea.setText(null);
            }
        });

    openFile.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
           
        }

        });

    saveFile.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
           
           
            }

        });
    
    
    printFile.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {


            }
        });

    exit.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
             System.exit(0);
            }
        });

    cut.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
            textArea.cut();            
            }
        });

    copy.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
            textArea.copy();
            }
        });

    paste.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
            textArea.paste();            
            }
        });
        

    selectAllText.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
            textArea.selectAll();            
            }
        });

    
    about.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent ev) {
             new AboutDialogueBox();          
            }
        });



    // Adding keyboard shortcuts 
    newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
    openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
    saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
    printFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
    exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
    copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
    paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
    selectAllText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));

    // Making frame visible 
    setVisible(true);
       
    }

    public static void main(String[] args) {

        new NotepadApp();

    }

        
}


class AboutDialogueBox extends JFrame {

    // Constructor of AboutDialogueBox class 
    
    AboutDialogueBox() { 

        setTitle("About");
        setLayout(null);
        setBounds(300,200,400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          
        // Add image
        // Image will be shown blank here 
        JLabel imageLabel = new JLabel();        
        imageLabel.setIcon(new ImageIcon("logo.png"));
        imageLabel.setBounds(170,50,70,70);
        add(imageLabel);

        // Adding text 
        JLabel textLabel = new JLabel("<html>This is a notepad app.<br>Credits @bishalcpgn </html>");
        textLabel.setFont(new Font("arial",Font.PLAIN,12));
        textLabel.setBounds(150, 120, 200, 80);
        add(textLabel);

        setVisible(true); 
    }
}

    