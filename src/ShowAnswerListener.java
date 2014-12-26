import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Luka on 26/12/14.
 */
public class ShowAnswerListener implements ActionListener {
    private QueryPanel questionPanel;
    private QueryPanel answerPanel;

    public ShowAnswerListener(QuizPanel quizPanel) {
        quizPanel.setLayout(new GridLayout(2, 1));
        questionPanel = quizPanel.getQuestionPanel();
        answerPanel = quizPanel.getAnswerPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        questionPanel.getButton().setVisible(false);
        answerPanel.setVisible(true);
    }
}
