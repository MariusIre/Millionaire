package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private boolean gameNotOver = true;
    private ArrayList<Question> gameQuestionsLv1 = new ArrayList<>();
    private ArrayList<Question> gameQuestionsLv2 = new ArrayList<>();
    private ArrayList<Question> gameQuestionsLv3 = new ArrayList<>();
    private ArrayList<Question> gameQuestionsLv4 = new ArrayList<>();
    private ArrayList<Question> gameQuestionsLv5 = new ArrayList<>();
    private ArrayList<Question> gameQuestionsInUse = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private int currentLevel = 1;
    private static final int MAX_LEVEL = 3;

    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    public Game() {
        // add questions to game
        ArrayList<Answer> answersQuestionLv1x0 = new ArrayList<>();
        answersQuestionLv1x0.add(new WrongAnswer("Answer1 v1.0"));
        answersQuestionLv1x0.add(new WrongAnswer("Answer2 v1.0"));
        answersQuestionLv1x0.add(new WrongAnswer("Answer3 v1.0"));
        answersQuestionLv1x0.add(new CorrectAnswer("Answer4 v1.0"));
        Question questionLv1x0 = new Question("Question v1.0?", 1, answersQuestionLv1x0);

        ArrayList<Answer> answersQuestionLv1x1 = new ArrayList<>();
        answersQuestionLv1x1.add(new WrongAnswer("Answer1 v1.1"));
        answersQuestionLv1x1.add(new WrongAnswer("Answer2 v1.1"));
        answersQuestionLv1x1.add(new WrongAnswer("Answer3 v1.1"));
        answersQuestionLv1x1.add(new CorrectAnswer("Answer4 v1.1"));
        Question questionLv1x1 = new Question("Question v1.1?", 1, answersQuestionLv1x1);

        ArrayList<Answer> answersQuestionLv2x0 = new ArrayList<>();
        answersQuestionLv2x0.add(new WrongAnswer("Answer1 v2.0"));
        answersQuestionLv2x0.add(new WrongAnswer("Answer2 v2.0"));
        answersQuestionLv2x0.add(new WrongAnswer("Answer3 v2.0"));
        answersQuestionLv2x0.add(new CorrectAnswer("Answer4 v2.0"));
        Question questionLv2x0 = new Question("Question v2.0?", 2, answersQuestionLv2x0);

        ArrayList<Answer> answersQuestionLv2x1 = new ArrayList<>();
        answersQuestionLv2x1.add(new WrongAnswer("Answer1 v2.1"));
        answersQuestionLv2x1.add(new WrongAnswer("Answer2 v2.1"));
        answersQuestionLv2x1.add(new WrongAnswer("Answer3 v2.1"));
        answersQuestionLv2x1.add(new CorrectAnswer("Answer4 v2.1"));
        Question questionLv2x1 = new Question("Question v2.1?", 2, answersQuestionLv2x1);

        ArrayList<Answer> answersQuestionLv3x0 = new ArrayList<>();
        answersQuestionLv3x0.add(new WrongAnswer("Answer1 v3.0"));
        answersQuestionLv3x0.add(new WrongAnswer("Answer2 v3.0"));
        answersQuestionLv3x0.add(new WrongAnswer("Answer3 v3.0"));
        answersQuestionLv3x0.add(new CorrectAnswer("Answer4 v3.0"));
        Question questionLv3x0 = new Question("Question v3.0?", 3, answersQuestionLv3x0);

        ArrayList<Answer> answersQuestionLv3x1 = new ArrayList<>();
        answersQuestionLv3x1.add(new WrongAnswer("Answer1 v3.1"));
        answersQuestionLv3x1.add(new WrongAnswer("Answer2 v3.1"));
        answersQuestionLv3x1.add(new WrongAnswer("Answer3 v3.1"));
        answersQuestionLv3x1.add(new CorrectAnswer("Answer4 v3.1"));
        Question questionLv3x1 = new Question("Question v3.1?", 3, answersQuestionLv3x1);

        ArrayList<Question> questionsLv1 = new ArrayList<>();
        ArrayList<Question> questionsLv2 = new ArrayList<>();
        ArrayList<Question> questionsLv3 = new ArrayList<>();
        questionsLv1.add(questionLv1x0);
        questionsLv1.add(questionLv1x1);
        questionsLv2.add(questionLv2x0);
        questionsLv2.add(questionLv2x1);
        questionsLv3.add(questionLv3x0);
        questionsLv3.add(questionLv3x1);

        this.gameQuestionsLv1.addAll(questionsLv1);
        this.gameQuestionsLv2.addAll(questionsLv2);
        this.gameQuestionsLv3.addAll(questionsLv3);
    }

    public void mainMenu() {
        //initializam intrebarile si jocul
        System.out.println("$$$ WHO WANTS TO BE A MILLIONAIRE $$$");
        System.out.println("Enter your username:");
        String username = scan.nextLine();
        System.out.println("Enter your pasword:");
        String password = scan.nextLine();
        Player player = new Player(username, password);
        players.add(player);
    }

    public void setQuestionsForLevels() {
        for (int i = 1; i < MAX_LEVEL; i++) {

        }
    }

    public void showQuestion(Question question) {
        String answerMark = "ABCDEF";
        System.out.println(question);
        for(Answer Answer : question.getAnswerList()) {
        }
    }

    public boolean answerQuestion(Question question) {
        //get user input and check if corret
        System.out.println("Your answer is?");
        String answerSentence = scan.nextLine();
        for (Answer answerToFind : question.getAnswerList()) {
            if (answerSentence.equalsIgnoreCase(answerToFind.getAnswerSentence())) {
                if (answerToFind.isCorrect()) {
                    System.out.println("The answer is correct.");
                    currentLevel++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean showGameOver(boolean gameStatus) {
        if (gameStatus) {
            if (!askForWithdraw()) {
                System.out.println("YOU WON THE PRIZE FOR LEVEL " + currentLevel);
                return false;
            }
        } else {
            System.out.println("YOU LOSE");
        }
        return gameStatus;
    }

    public boolean askForWithdraw() {
        System.out.println("Do you wish to continue? (Y/N)");
        String answer = scan.nextLine();
        return answer.equalsIgnoreCase("y");
    }

    public void endMenu() {
        System.out.println("N - new game / Q - quit");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            mainMenu();
        }
    }

    public void fiftyFifty() {
        //show the same question but with only 2 possible answers
    }

}
