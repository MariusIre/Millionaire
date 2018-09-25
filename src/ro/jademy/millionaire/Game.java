package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int MAX_LEVEL = 3;
    private boolean gameOver = false;
    private ArrayList<Question> gameQuestions = new ArrayList<>();
    private ArrayList<Question> gameQuestionsInUse = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private int currentLevel = 1;
    private int fiftyFiftyTries = 2;

    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    public Game() {
        // add questions to game
        ArrayList<Answer> answersQuestionLv1x0 = new ArrayList<>();
        answersQuestionLv1x0.add(new WrongAnswer("Mont Blanc"));
        answersQuestionLv1x0.add(new WrongAnswer("Aconcagua"));
        answersQuestionLv1x0.add(new WrongAnswer("Kilimanjaro"));
        answersQuestionLv1x0.add(new CorrectAnswer("Chomolungma"));
        Question questionLv1x0 = new Question("Which is the tallest mountain on earth?", 1, answersQuestionLv1x0);

        ArrayList<Answer> answersQuestionLv1x1 = new ArrayList<>();
        answersQuestionLv1x1.add(new WrongAnswer("Is over 9000!"));
        answersQuestionLv1x1.add(new WrongAnswer("10000m"));
        answersQuestionLv1x1.add(new WrongAnswer("8148m"));
        answersQuestionLv1x1.add(new CorrectAnswer("8848m"));
        Question questionLv1x1 = new Question("how high is the mountain Everest?", 1, answersQuestionLv1x1);

        ArrayList<Answer> answersQuestionLv2x0 = new ArrayList<>();
        answersQuestionLv2x0.add(new WrongAnswer("Stephen King"));
        answersQuestionLv2x0.add(new WrongAnswer("Clive Staples Lewis"));
        answersQuestionLv2x0.add(new WrongAnswer("Arthur Conan Doyle"));
        answersQuestionLv2x0.add(new CorrectAnswer("J. K. Rowling"));
        Question questionLv2x0 = new Question("Who wrote Harry Potter?", 2, answersQuestionLv2x0);

        ArrayList<Answer> answersQuestionLv2x1 = new ArrayList<>();
        answersQuestionLv2x1.add(new WrongAnswer("J. K. Rowling"));
        answersQuestionLv2x1.add(new WrongAnswer("Stephen King"));
        answersQuestionLv2x1.add(new WrongAnswer("Arthur Conan Doyle"));
        answersQuestionLv2x1.add(new CorrectAnswer("Clive Staples Lewis"));
        Question questionLv2x1 = new Question("Who wrote Chronicles of Narnia?", 2, answersQuestionLv2x1);

        ArrayList<Answer> answersQuestionLv3x0 = new ArrayList<>();
        answersQuestionLv3x0.add(new WrongAnswer("14014m"));
        answersQuestionLv3x0.add(new WrongAnswer("10000m"));
        answersQuestionLv3x0.add(new WrongAnswer("8848m"));
        answersQuestionLv3x0.add(new CorrectAnswer("10,994m"));
        Question questionLv3x0 = new Question("How deep is Marianas Trench?", 3, answersQuestionLv3x0);

        ArrayList<Answer> answersQuestionLv3x1 = new ArrayList<>();
        answersQuestionLv3x1.add(new WrongAnswer("HMRG Deep"));
        answersQuestionLv3x1.add(new WrongAnswer("Challenger II"));
        answersQuestionLv3x1.add(new WrongAnswer("Mariana Hollow"));
        answersQuestionLv3x1.add(new CorrectAnswer("Challenger Deep"));
        Question questionLv3x1 = new Question("How the deepest point in Marianas Trench is called?", 3, answersQuestionLv3x1);

        this.gameQuestions.add(questionLv1x0);
        this.gameQuestions.add(questionLv1x1);
        this.gameQuestions.add(questionLv2x0);
        this.gameQuestions.add(questionLv2x1);
        this.gameQuestions.add(questionLv3x0);
        this.gameQuestions.add(questionLv3x1);
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ArrayList<Question> getGameQuestionsInUse() {
        return gameQuestionsInUse;
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
        for (int i = 1; i <= MAX_LEVEL; i++) {
            ArrayList<Question> gameQuestionsPerLevel = getQuestionsPerLevel(i);
            gameQuestionsInUse.add(getRandomQuestionFromArray(gameQuestionsPerLevel));
        }
    }

    private ArrayList<Question> getQuestionsPerLevel(int difficulty) {
        ArrayList<Question> questionsPerLevel = new ArrayList<>();
        for (Question question : gameQuestions) {
            if (question.getDifficultyLevel() == difficulty) {
                questionsPerLevel.add(question);
            }
        }
        return questionsPerLevel;
    }

    private Question getRandomQuestionFromArray(ArrayList<Question> gameQuestions) {
        return gameQuestions.get(rand.nextInt(gameQuestions.size()));
    }

    public boolean askForFiftyFifty () {
        System.out.println("Fifty fifty tries remaining: " + fiftyFiftyTries);
        System.out.println("Do you want to use fifty fifty on this question?(Y/N)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y")){
            fiftyFiftyTries--;
            return true;
        }
        return false;
    }

    public int getFiftyFiftyTries () {
        return fiftyFiftyTries;
    }

    public boolean askForWithdraw() {
        System.out.println("Do you wish to continue? (Y/N)");
        String answer = scan.nextLine();
        return answer.equalsIgnoreCase("y");
    }

    public boolean endMenu() {
        gameQuestionsInUse.clear();
        fiftyFiftyTries = 2;
        System.out.println("N - new game / Q - quit");
        boolean goodAnswer = false;
        do {
            String answer = scan.nextLine();
            switch (answer) {
                case "N" :
                    return true;
                case "Q" :
                    return false;
                default :
                    System.out.println("Incorrect input please use N or Q to choose.");
            }
        } while (!goodAnswer);
        return true;
    }
}
