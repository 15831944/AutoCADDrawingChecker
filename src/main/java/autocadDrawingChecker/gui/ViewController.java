package autocadDrawingChecker.gui;

import autocadDrawingChecker.files.FileChooserUtil;
import autocadDrawingChecker.logging.Logger;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

/**
 *
 * @author Matt
 */
public class ViewController extends JFrame {
    public ViewController(){
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.logError(ex);
        }
        
        JMenuBar menuBar = new JMenuBar();
        JMenu logMenu = new JMenu("Log");
        JMenuItem saveLog = new JMenuItem("Save Log");
        saveLog.addActionListener((e)->{
            FileChooserUtil.askCreateTextFile("Where do you want to save this log?", Logger.getLog());
        });
        logMenu.add(saveLog);
        menuBar.add(logMenu);
        setJMenuBar(menuBar);
        
        setContentPane(new AppPane());
        // fullscreen
        setSize(
            (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 
            (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).bottom
        );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        revalidate();
        repaint();
    }
}