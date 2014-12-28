import javax.swing.*;

public class QuizPanel extends JPanel {
    protected QuestionPanel questionPanel;
    protected AnswerPanel answerPanel;

    protected QuizPanel() {
        questionPanel = new QuestionPanel();
        answerPanel = new AnswerPanel();
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

