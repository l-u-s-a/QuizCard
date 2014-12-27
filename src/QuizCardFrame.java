import com.sun.java.swing.action.FileMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Iterator;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardFrame extends JFrame {
    private QuizPlayerPanel quizPlayerPanel;
    private QuizBuilderPanel quizBuilderPanel;

    public QuizCardFrame() {
        setLayout(new BorderLayout());
        setSize(640, 500);
        addMenuCompoments();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addMenuCompoments() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem loadFile = new JMenuItem("Load cards...");
        JMenuItem saveFile = new JMenuItem("Save cards as...");
        JMenuItem exitFile = new JMenuItem("Exit");
        menu.add(newFile);
        menu.add(loadFile);
        menu.add(saveFile);
        menu.add(exitFile);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizBuilderPanel = new QuizBuilderPanel();
                add(BorderLayout.CENTER, quizBuilderPanel);
//                QuizCardBuilder.reset();
                setVisible(true);
            }
        });

        loadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser loadFile = new JFileChooser();
                loadFile.showOpenDialog(getParent());
                loadCards(loadFile.getSelectedFile());
                setupPlayerPanel();
            }

            private void loadCards(File selectedFile) {
//                QuizCardBuilder.reset();

                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile));
                    String line = null;
                    while((line = bufferedReader.readLine()) != null) {
                        String[] splittedLine = line.split("->");
                        if (splittedLine.length == 2)
                            QuizCardBuilder.cardList.add(new QuizCard(splittedLine[0], splittedLine[1]));
                    }
                    bufferedReader.close();
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(getContentPane(), "File not found.");
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(getContentPane(), "Incopatibile inputFile");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setupPlayerPanel() {
        quizPlayerPanel = new QuizPlayerPanel();
        quizPlayerPanel.setIterator(QuizCardBuilder.cardList.iterator());
        add(BorderLayout.CENTER, quizPlayerPanel);
        setVisible(true);
    }

    private void setupBuilderPanel() {
//        currentPanel = new
    }

}
