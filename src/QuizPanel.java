import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

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

    protected void clearTextFields() {
        questionPanel.getTextArea().setText("");
        answerPanel.getTextArea().setText("");
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
            clearTextFields();
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
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selectedFile));
            for (QuizCard quizCard : QuizCardBuilder.cardList) {
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

class QuizPlayerPanel extends QuizPanel {

    private Iterator<QuizCard> iterator = QuizCardBuilder.cardList.iterator();

    public void setIterator(Iterator<QuizCard> iterator) {
        this.iterator = iterator;
    }

    public Iterator<QuizCard> getIterator() {
        return iterator;
    }

    public QuizPlayerPanel() {
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER, questionPanel);
        configurePanels();
        loadNextCard();
    }

    private void configurePanels() {
        questionPanel.getTextArea().setEditable(false);
        answerPanel.getTextArea().setEditable(false);
        questionPanel.getButton().addActionListener(new ShowAnswerListener());
        answerPanel.getButton().addActionListener(new NextCardListener());

    }

    private void loadNextCard() {
        QuizCard quizCard;
        if (iterator.hasNext()) {
            quizCard = iterator.next();
            questionPanel.getTextArea().setText(quizCard.getQuestion());
            answerPanel.getTextArea().setText(quizCard.getAnswer());
        }
    }

    private void fillWithQuestionPanel() {
        answerPanel.setVisible(false);
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER, questionPanel);
        questionPanel.getButton().setVisible(true);

    }


    private class ShowAnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setLayout(new GridLayout(2, 1));
            answerPanel.setVisible(true);
            add(answerPanel);
            questionPanel.getButton().setVisible(false);
        }
    }

    private class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!iterator.hasNext()) {
                JOptionPane.showMessageDialog(getParent(), "That's last question!");
            } else {
                loadNextCard();
                fillWithQuestionPanel();
            }
        }
    }


}
