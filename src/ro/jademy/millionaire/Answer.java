package ro.jademy.millionaire;

public abstract class Answer {
    private String answerSentence;

    public Answer (String answerSentence) {
        this.answerSentence = answerSentence;
    }

    public String getAnswerSentence (){
        return answerSentence;
    }

    abstract boolean isCorrect ();
}
