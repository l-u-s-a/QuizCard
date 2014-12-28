import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Luka on 28/12/14.
 */
public class MyJMenuBar extends JMenuBar {
    private static JMenu fileMenu = new JMenu("File");
    private static JMenu editMenu = new JMenu("Edit");
    private static JMenu helpMenu = new JMenu("Help");
    private static JMenuItem newFile = new JMenuItem("New");
    private static JMenuItem loadFile = new JMenuItem("Load cards...");
    private static JMenuItem saveFile = new JMenuItem("Save cards as...");
    private static JMenuItem exit = new JMenuItem("Exit");
    private static JMenuItem clearTextAreas = new JMenuItem("Clear");
    private static JMenuItem about = new JMenuItem("About");



    public MyJMenuBar() {
        initializeMenuBar();
        add(fileMenu);
        add(editMenu);
        add(helpMenu);
        setListeners();
    }

    private void initializeMenuBar() {
        initFileMenu();
        initEditMenu();
        initHelpMenu();
    }

    private void initHelpMenu() {
        helpMenu.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(QuizCardBuilder.frame, "QuizCard v" + QuizCardBuilder.version);
            }
        });
    }

    private void initEditMenu() {
        clearTextAreas.setEnabled(false);
        editMenu.add(clearTextAreas);

    }

    private void setListeners() {
        newFile.addActionListener(new NewCardBuilderListener());
        loadFile.addActionListener(new LoadCardPlayerListener());
        saveFile.addActionListener(new SaveMenuListener());
        exit.addActionListener(new ExitMenuListener());
        clearTextAreas.addActionListener(new ClearTextAreasListener());
    }

    private void initFileMenu() {
        fileMenu.add(newFile);
        fileMenu.addSeparator();
        fileMenu.add(loadFile);
        saveFile.setEnabled(false);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);
    }

    public static JMenuItem getAbout() {
        return about;
    }

    public static JMenuItem getClearTextAreas() {
        return clearTextAreas;
    }

    public static JMenuItem getExit() {
        return exit;
    }

    public static JMenu getEditMenu() {
        return editMenu;
    }

    public static JMenu getFileMenu() {
        return fileMenu;
    }

    public static JMenuItem getNewFile() {
        return newFile;
    }

    public static JMenuItem getLoadFile() {
        return loadFile;
    }

    public static JMenuItem getSaveFile() {
        return saveFile;
    }

    public static JMenuItem getExitFile() {
        return exit;
    }
}
