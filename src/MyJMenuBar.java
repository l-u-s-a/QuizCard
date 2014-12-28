import javax.swing.*;

/**
 * Created by Luka on 28/12/14.
 */
public class MyJMenuBar extends JMenuBar {
    private static JMenu fileMenu = new JMenu("File");
    private static JMenuItem newFile = new JMenuItem("New");
    private static JMenuItem loadFile = new JMenuItem("Load cards...");
    private static JMenuItem saveFile = new JMenuItem("Save cards as...");
    private static JMenuItem exitFile = new JMenuItem("Exit");

    public MyJMenuBar() {
        initFileMenu();
        add(fileMenu);
        setListeners();
    }

    private void setListeners() {
        newFile.addActionListener(new NewCardBuilderListener());
        loadFile.addActionListener(new LoadCardPlayerListener());
        saveFile.addActionListener(new SaveMenuListener());
        exitFile.addActionListener(new ExitMenuListener());
    }

    private void initFileMenu() {
        fileMenu.add(newFile);
        fileMenu.addSeparator();
        fileMenu.add(loadFile);
        saveFile.setEnabled(false);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(exitFile);
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
        return exitFile;
    }
}
