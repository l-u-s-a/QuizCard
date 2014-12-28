import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Luka on 28/12/14.
 */
public class ExitMenuListener extends WindowAdapter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        openDialog();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        openDialog();
    }

    private void openDialog() {
        int answer = JOptionPane.showConfirmDialog(QuizCardBuilder.frame.getParent(), "Are you sure?", "Closing", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}
