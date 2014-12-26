import javax.swing.*;
import java.awt.*;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardBuilderFrame extends JFrame {
    private QuizBuilderPanel quizBuilderPanel = new QuizBuilderPanel();

    public QuizCardBuilderFrame() {
        super("Quiz Card Builder");
        setLayout(new BorderLayout());
        setSize(640, 500);
        add(BorderLayout.CENTER, quizBuilderPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
