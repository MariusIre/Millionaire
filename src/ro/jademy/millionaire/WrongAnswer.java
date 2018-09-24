package ro.jademy.millionaire;

public class WrongAnswer extends Answer {

    public WrongAnswer (String answerSentence) {
        super(answerSentence);
    }

    @Override
    public boolean isCorrect () {
        return false;
    }


}
