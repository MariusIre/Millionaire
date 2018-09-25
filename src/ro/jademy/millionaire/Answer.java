package ro.jademy.millionaire;

public abstract class Answer {
    private String answerSentence;

    Answer (String answerSentence) {
        this.answerSentence = answerSentence;
    }

    void setAnswerSentence(String answerSentence) {
        this.answerSentence = answerSentence;
    }

    abstract boolean isCorrect ();

    @Override
    public String toString () {
        return answerSentence;
    }
}
