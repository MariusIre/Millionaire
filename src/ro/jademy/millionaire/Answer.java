package ro.jademy.millionaire;

import java.util.Objects;

public class Answer {
    String answerSentence;
    boolean isCorrect;

    Answer () {}

    Answer (String answerSentence , boolean isCorrect) {
        this.answerSentence = answerSentence;
        this.isCorrect = isCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return isCorrect == answer1.isCorrect &&
                Objects.equals(answerSentence, answer1.answerSentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerSentence, isCorrect);
    }
}
