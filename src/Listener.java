import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Listener implements ActionListener {
    protected QuizCardFrame frame;
    protected Container contentPane;

    public void actionPerformed(ActionEvent e) {
        frame = QuizCardBuilder.frame;
        contentPane = frame.getContentPane();
    }
}







