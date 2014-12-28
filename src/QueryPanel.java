import javax.swing.*;
import java.awt.*;

public class QueryPanel extends JPanel {
    protected JTextArea textArea = new JTextArea();
    protected JButton button = new JButton();

    protected QueryPanel() {
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER, textArea);
        add(BorderLayout.SOUTH, button);
        textArea.setLineWrap(true);
        
        setVisible(true);
    }


    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getButton() {
        return button;
    }

}

class QuestionPanel extends QueryPanel {
    public QuestionPanel() {
        textArea.setBorder(BorderFactory.createTitledBorder("Question"));
        button.setText("Show Answer");
    }
}

class AnswerPanel extends QueryPanel {
    public AnswerPanel() {
        textArea.setBorder(BorderFactory.createTitledBorder("Answer"));
        button.setText("Next Card");
    }
}