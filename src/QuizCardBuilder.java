import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardBuilder {
    public static ArrayList<QuizCard> cardList = new ArrayList<QuizCard>();
    private static QuizCard currentCard;
    private static int currentCardIndex;
    public static JFrame frame;
    private static JButton nextButton;
    private static boolean isShowAnswer;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame = new QuizCardFrame();
                }
            });
    }

    public static void reset() {
        cardList = new ArrayList<QuizCard>();
        currentCard = null;
        currentCardIndex = 0;
        nextButton = null;
        isShowAnswer = false;
    }
}
