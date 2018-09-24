package ro.jademy.millionaire;

public class CorrectAnswer extends Answer {

    public CorrectAnswer(String answerSentence) {
        super(answerSentence);
    }

    @Override
    public boolean isCorrect() {
        return true;
    }
}
