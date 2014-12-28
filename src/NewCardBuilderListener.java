import java.awt.*;
import java.awt.event.ActionEvent;

public class NewCardBuilderListener extends Listener {
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        contentPane.removeAll();
        QuizCardBuilder.reset();
        QuizBuilderPanel newQuizBuilderPanel = new QuizBuilderPanel();
        frame.setQuizBuilderPanel(newQuizBuilderPanel);
        MyJMenuBar.getClearTextAreas().setEnabled(true);

        contentPane.add(BorderLayout.CENTER, newQuizBuilderPanel);
        QuizCardBuilder.frame.revalidate();
    }
}