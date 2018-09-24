package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {
    public static final int MAX_LEVEL = 15;

    private String questionSentence;
    private int difficultyLevel; //max 15
    private List<Answer> answerList = new ArrayList<>();
    private boolean hasBeenAsked = false;

    public Question(String questionSentence, int difficultyLevel, List<Answer> answerList) {
        this.questionSentence = questionSentence;
        this.difficultyLevel = difficultyLevel;
        this.answerList.addAll(answerList);
    } //constructor

    public String getQuestionSentence() {
        return questionSentence;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public boolean getHasQuestionBeenAsked() {
        return hasBeenAsked;
    }

    public void setQuestionSentence(String questionSentence) {
        this.questionSentence = questionSentence;
    }

    public void setQuestionDifficulty(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return difficultyLevel == question.difficultyLevel &&
                Objects.equals(questionSentence, question.questionSentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionSentence, difficultyLevel);
    }

    @Override
    public String toString () {
        return questionSentence;
    }
}
