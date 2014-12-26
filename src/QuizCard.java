import java.io.Serializable;

/**
 * Created by Luka on 23/12/14.
 */
public class QuizCard implements Serializable {
    private String question;
    private String answer;

    public QuizCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof QuizCard) {
            QuizCard quizCard = (QuizCard)object;
            return quizCard.getQuestion() == question && quizCard.answer == answer;
        } else
            return false;
    }
}
