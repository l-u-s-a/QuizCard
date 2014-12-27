import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardBuilder {
    public static ArrayList<QuizCard> cardList = new ArrayList();
    private static QuizCard currentCard;
    private static int currentCardIndex;
    private JFrame frame;
    private static JButton nextButton;
    private static boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardBuilder quizCardBuilder = new QuizCardBuilder();
        quizCardBuilder.go();
    }


    public void go() {
        frame = new QuizCardFrame();
    }

    public static void reset() {
        cardList = new ArrayList<QuizCard>();
        currentCard = null;
        currentCardIndex = 0;
        nextButton = null;
        isShowAnswer = false;
    }

}
