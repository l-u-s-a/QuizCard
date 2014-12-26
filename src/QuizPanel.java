import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class QuizPanel extends JPanel {
    protected QueryPanel questionPanel = new QuestionPanel();
    protected QueryPanel answerPanel = new AnswerPanel();

    protected QuizPanel() {
    }

    public QueryPanel getQuestionPanel() {
        return questionPanel;
    }

    public QueryPanel getAnswerPanel() {
        return answerPanel;
    }
}

class QuizBuilderPanel extends QuizPanel {

    public QuizBuilderPanel() {
        setLayout(new GridLayout(2, 1));
        questionPanel.getButton().setVisible(false);
        add(questionPanel);
        add(answerPanel);
        answerPanel.getButton().addActionListener(new NextCardListener());
    }

    private class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCardBuilder.cardList.add(new QuizCard(questionPanel.getTextArea().getText(), answerPanel.getTextArea().getText()));
            questionPanel.getTextArea().setText("");
            answerPanel.getTextArea().setText("");
        }
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
        
    }
}

class QuizPlayerPanel extends QuizPanel {
    public QuizPlayerPanel() {
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER, questionPanel);
        questionPanel.getButton().addActionListener(new ShowAnswerListener(this));
    }
}
