import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Luka on 28/12/14.
 */
public class ClearTextAreasListener implements ActionListener {
    private QuizBuilderPanel quizBuilderPanel;

    @Override
    public void actionPerformed(ActionEvent e) {
        quizBuilderPanel = QuizCardBuilder.frame.getQuizBuilderPanel();

        quizBuilderPanel.getQuestionPanel().getTextArea().setText("");
        quizBuilderPanel.getAnswerPanel().getTextArea().setText("");

        quizBuilderPanel.getQuestionPanel().getTextArea().requestFocus();
    }
}
