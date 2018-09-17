package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public static final int MAX_LEVEL = 15;

    public String question;
    public int difficultyLevel; //max 15
    public List<Answer> answerList = new ArrayList<>();

    public Answer getCorrectAnswer() {
        for (Answer answer : answerList) {
            if(answer.isCorrect) {
                return answer;
            }
        }
        return null;
    }
}
