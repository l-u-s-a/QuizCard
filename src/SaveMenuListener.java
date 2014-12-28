import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveMenuListener extends Listener {
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(frame.getParent());
        if (fileChooser.getSelectedFile() != null) {
            saveFile(fileChooser.getSelectedFile());
            MyJMenuBar.getSaveFile().setEnabled(false);
            contentPane.removeAll();
            QuizBuilderPanel newQuizBuilderPanel = new QuizBuilderPanel();
            frame.setQuizBuilderPanel(newQuizBuilderPanel);
            contentPane.add(BorderLayout.CENTER, newQuizBuilderPanel);
            frame.revalidate();
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
}