import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardFrame extends JFrame {
    private QuizPlayerPanel quizPlayerPanel;
    private QuizBuilderPanel quizBuilderPanel;
    private JMenuBar menuBar = new MyJMenuBar();


    public QuizCardFrame() {
        setSize(640, 500);
        setJMenuBar(menuBar);
        addWindowListener(new ExitMenuListener());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setVisible(true);
    }

    public QuizPlayerPanel getQuizPlayerPanel() {
        return quizPlayerPanel;
    }

    public QuizBuilderPanel getQuizBuilderPanel() {
        return quizBuilderPanel;
    }


    public void setQuizPlayerPanel(QuizPlayerPanel quizPlayerPanel) {
        this.quizPlayerPanel = quizPlayerPanel;
    }

    public void setQuizBuilderPanel(QuizBuilderPanel quizBuilderPanel) {
        this.quizBuilderPanel = quizBuilderPanel;
    }
}
