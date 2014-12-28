import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class QuizPlayerPanel extends QuizPanel {

    private Iterator<QuizCard> iterator;

    public void setIterator(Iterator<QuizCard> iterator) {
        this.iterator = iterator;
    }

    public Iterator<QuizCard> getIterator() {
        return iterator;
    }

    public QuizPlayerPanel() {
        setIterator(QuizCardBuilder.cardList.iterator());
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
                JOptionPane.showMessageDialog(getParent(), "No more questions!");
            } else {
                loadNextCard();
                fillWithQuestionPanel();
            }
        }
    }
}
