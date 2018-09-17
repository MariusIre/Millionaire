package ro.jademy.millionaire;

import java.util.Objects;

public class Answer {
    String answer;
    boolean isCorrect;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return isCorrect == answer1.isCorrect &&
                Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, isCorrect);
    }
}
