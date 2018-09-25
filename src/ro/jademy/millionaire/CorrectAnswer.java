package ro.jademy.millionaire;

public class CorrectAnswer extends Answer {

    CorrectAnswer(String answerSentence) {
        super(answerSentence);
    }

    @Override
    public boolean isCorrect() {
        return true;
    }
}
