import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class LoadCardPlayerListener extends Listener {
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JFileChooser loadFile = new JFileChooser();
        loadFile.showOpenDialog(frame.getParent());
        if (loadFile.getSelectedFile() != null) {
            contentPane.removeAll();
            QuizCardBuilder.reset();
            loadCards(loadFile.getSelectedFile());
            QuizPlayerPanel newQuizPlayerPanel = new QuizPlayerPanel();
            frame.setQuizPlayerPanel(newQuizPlayerPanel);
            MyJMenuBar.getClearTextAreas().setEnabled(false);
            contentPane.add(BorderLayout.CENTER, newQuizPlayerPanel);
            frame.revalidate();
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
            JOptionPane.showMessageDialog(contentPane, "File not found.");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(contentPane, "Incopatibile inputFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}