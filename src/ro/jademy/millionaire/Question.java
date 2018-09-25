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

    void showQuestionAndAnswers() {
        String answerMark = "ABCD";
        System.out.println("\n" + questionSentence + "\n");
        for (int i = 0; i <= 3; i++) {
            System.out.println(answerMark.charAt(i) + " " + answerList.get(i));
        }
        System.out.println();
    }

    boolean answerQuestion() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Your answer to the question is?");
        String answerSentence = scan.nextLine();
        if (answerQuestionByMark(answerSentence) || answerQuestionBySentence(answerSentence)) {
            System.out.println("The answer is correct.");
            return false;
        }
        System.out.println("You lost!");
        return true;
    }

    private boolean answerQuestionBySentence(String answerSentence) {
        for (Answer answerToFind : answerList) {
            if (answerSentence.equalsIgnoreCase(answerToFind.toString())) {
                if (answerToFind.isCorrect()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean answerQuestionByMark(String answerMark) {
        switch (answerMark) {
            case "A":
            case "a":
                return answerList.get(0).isCorrect();
            case "B":
            case "b":
                return answerList.get(1).isCorrect();
            case "C":
            case "c":
                return answerList.get(2).isCorrect();
            case "D":
            case "d":
                return answerList.get(3).isCorrect();
            default:
                return false;
        }
    }

    void fiftyFifty() {
        Random rand = new Random();
        int randomInt;
        int numberOfChangedAnswers = 0;
        do {
            randomInt = rand.nextInt(answerList.size());
            if (!answerList.get(randomInt).isCorrect() &&
                    !answerList.get(randomInt).toString().equalsIgnoreCase("")) {
                answerList.get(randomInt).setAnswerSentence("");
                numberOfChangedAnswers++;
            }
        } while (numberOfChangedAnswers < 2);
        showQuestionAndAnswers();
    }

    @Override
    public String toString() {
        return questionSentence;
    }
}
