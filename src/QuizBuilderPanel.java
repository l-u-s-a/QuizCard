import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizBuilderPanel extends QuizPanel {
    public QuizBuilderPanel() {
        setLayout(new GridLayout(2, 1));
        questionPanel.getButton().setVisible(false);
        questionPanel.getButton().setEnabled(false);
        add(questionPanel);
        add(answerPanel);
        answerPanel.getButton().addActionListener(new NextCardListener());
        questionPanel.getTextArea().setEditable(true);
        answerPanel.getTextArea().setEditable(true);
    }

    private class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCardBuilder.cardList.add(new QuizCard(questionPanel.getTextArea().getText(), answerPanel.getTextArea().getText()));
            MyJMenuBar.getSaveFile().setEnabled(true);
            clearTextFields();
        }
    }
}
