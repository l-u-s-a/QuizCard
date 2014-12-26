import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardBuilder {
    public static ArrayList<QuizCard> cardList = new ArrayList();
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardBuilder quizCardBuilder = new QuizCardBuilder();
        quizCardBuilder.go();
    }

    public void go() {
        frame = new QuizCardBuilderFrame();

    }

}
