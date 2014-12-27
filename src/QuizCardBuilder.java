import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCardBuilder {
    public static ArrayList<QuizCard> cardList = new ArrayList();
    private static QuizCard currentCard;
    private static int currentCardIndex;
    public static JFrame frame;
    private static JButton nextButton;
    private static boolean isShowAnswer;
    private static QuizCardBuilder quizCardBuilder = new QuizCardBuilder();

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    quizCardBuilder.frame = new QuizCardFrame();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
//        cardList = new ArrayList<QuizCard>();
//        currentCard = null;
//        currentCardIndex = 0;
//        nextButton = null;
//        isShowAnswer = false;
        quizCardBuilder = new QuizCardBuilder();
    }
}
