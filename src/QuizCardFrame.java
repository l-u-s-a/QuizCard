import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardFrame extends JFrame {
    private QuizPlayerPanel quizPlayerPanel;
    private QuizBuilderPanel quizBuilderPanel;
    private Container container = new JPanel(new CardLayout());
    private final String player = "player";
    private final String builder = "builder";
    private final String welcome = "welcome";


    public QuizCardFrame() {
        setSize(640, 500);
        addMenuCompoments();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setVisible(true);
//        container.add(welcomePanel, welcome);
//        container.add(quizPlayerPanel, player);
//        container.add(quizBuilderPanel, builder);
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
        newFile.addActionListener(new NewCardBuilderListener());
        loadFile.addActionListener(new LoadCardPlayerListener());
        saveFile.addActionListener(new SaveMenuListener());
    }

    private class SaveMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(getParent());
            saveFile(fileChooser.getSelectedFile());
        }
    }

    private void saveFile(File selectedFile) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selectedFile));
            for (QuizCard quizCard : QuizCardBuilder.cardList) {
                if (quizCard.getQuestion().equals("")) continue;
                bufferedWriter.write(quizCard.getQuestion() + " -> ");
                bufferedWriter.write(quizCard.getAnswer() + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class NewCardBuilderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            QuizCardBuilder.reset();
            quizBuilderPanel = new QuizBuilderPanel();
            getContentPane().add(BorderLayout.CENTER, quizBuilderPanel);
            revalidate();
            }
        }

    private class LoadCardPlayerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            JFileChooser loadFile = new JFileChooser();
            loadFile.showOpenDialog(getParent());
            QuizCardBuilder.reset();
            if (loadFile.getSelectedFile() != null) {
                loadCards(loadFile.getSelectedFile());
                quizPlayerPanel = new QuizPlayerPanel();
                getContentPane().add(BorderLayout.CENTER, quizPlayerPanel);
//                        ((CardLayout) container.getLayout()).show(container, player);
                revalidate();
            }

        }
    }

        private void loadCards(File selectedFile) {
            QuizCardBuilder.reset();
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
    }
