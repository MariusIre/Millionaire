package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question {

    private String questionSentence;
    private int difficultyLevel;
    private ArrayList<Answer> answerList = new ArrayList<>();

    Question(String questionSentence, int difficultyLevel, ArrayList<Answer> answerList) {
        this.questionSentence = questionSentence;
        this.difficultyLevel = difficultyLevel;
        this.answerList.addAll(answerList);
    }

    int getDifficultyLevel() {
        return difficultyLevel;
    }

    ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void showQuestion() {
        String answerMark = "ABCDEF";
        int answerMarkIndex = 0;
        System.out.println(questionSentence);
        for (Answer answer : answerList) {
            System.out.println(answerMark.charAt(answerMarkIndex) + " " + answer + ".");
            answerMarkIndex++;
        }
    }

    public boolean answerQuestion() {
        //get user input and check if corret
        Scanner scan = new Scanner(System.in);
        System.out.println("Your answer is?");
        String answerSentence = scan.nextLine();
        for (Answer answerToFind : answerList) {
            if (answerSentence.equalsIgnoreCase(answerToFind.toString())) {
                if (answerToFind.isCorrect()) {
                    System.out.println("The answer is correct.");
                    return false;
                }
            }
        }
        System.out.println("You lost!");
        return true;
    }

    private boolean answerQuestionBySentence(String answerSentence) {
        for (Answer answerToFind : answerList) {
            if (answerSentence.equalsIgnoreCase(answerToFind.toString())) {
                if (answerToFind.isCorrect()) {
                    System.out.println("The answer is correct.");
                    return false;
                }
            }
        }
        return true;
    }  //not in use yet, needs adjustment

    private void answerQuestionByMark () {} //not in use yet, needs adjustment

    public void fiftyFifty() {
        Random rand = new Random();
        ArrayList<Answer> answerListFiftyFifty = this.answerList;
        do {
            Answer answer = answerListFiftyFifty.get(rand.nextInt(answerListFiftyFifty.size()));
            if (!answer.isCorrect()) {
                answerListFiftyFifty.remove(answer);
            }
        } while (answerListFiftyFifty.size() > 2);
        showQuestion();
    }

    @Override
    public String toString() {
        return questionSentence;
    }
}
