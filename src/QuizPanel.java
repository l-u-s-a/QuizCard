import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class QuizPanel extends JPanel {
    protected QuestionPanel questionPanel;
    protected AnswerPanel answerPanel;

    protected QuizPanel() {
        questionPanel = new QuestionPanel();
        answerPanel = new AnswerPanel();

        //needs tab switching implementation
//        questionPanel.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
//                e.ge
//            }
//        });
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

