package ro.jademy.millionaire;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    boolean gameNotOver = true;
    List<Question> gameQuestions = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    int currentLevel = 1;

    private Scanner scan = new Scanner(System.in);

    public void mainMenu() {
        //initializam intrebarile si jocul
        System.out.println("$$$ WHO WANTS TO BE A MILLIONAIRE $$$");
        Player player = getPlayerInfo();
    }

    public Player getPlayerInfo () {
        Player player = new Player();
        System.out.println("Enter your username:");
        player.username = scan.nextLine();
        System.out.println("Enter your pasword:");
        player.password = scan.nextLine();
        players.add(player);
        return player;
    }

    public Question setQuestion() {
        System.out.println("Game current level is " + currentLevel);
        for (Question question : gameQuestions) {
            if (!question.hasBeenAsked && currentLevel == question.difficultyLevel) {
                showQuestion(question);
                question.hasBeenAsked = true;
                return question;
            }
        }
        Question emptyQuestion = new Question();
        emptyQuestion.questionSentence = " EMPTY TEST QUESTION";
        return emptyQuestion;
    }

    public void showQuestion(Question question) {
        //show question on screen
        String questionMarks = "ABCDEF";
        System.out.println(question.questionSentence);
        for (Answer answer : question.answerList) {
            System.out.print(questionMarks.charAt(question.answerList.indexOf(answer)));
            System.out.println(" " + answer.answerSentence);
        }
    }

    public boolean answerQuestion(Question question) {
        //get user input and check if corret
        System.out.println("Your answer is?");
        String answerSentence = scan.nextLine();
        for (Answer answerToFind : question.answerList) {
            if (answerToFind.answerSentence.equalsIgnoreCase(answerSentence)) {
                System.out.println("The answer is correct.");
                currentLevel++;
                return true;
            }
        }
        return false;
    }

    public boolean showGameOver(boolean gameStatus) {
        if (gameStatus) {
            if(!askForWithdraw()) {
                System.out.println("YOU WON THE PRIZE FOR LEVEL " + currentLevel);
                return false;
            }
        } else {
            System.out.println("YOU LOSE");
        }
        return gameStatus;
    }

    public boolean askForWithdraw () {
        System.out.println("Do you wish to continue? (Y/N)");
        String answer = scan.nextLine();
        return answer.equalsIgnoreCase("y");
    }

    public void endMenu () {
        System.out.println("N - new game / Q - quit");
        String answer = scan.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            mainMenu();
        }
    }

    public void fiftyFifty () {
        //show the same question but with only 2 possible answers
    }

}
