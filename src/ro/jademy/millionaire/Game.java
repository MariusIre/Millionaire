package ro.jademy.millionaire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
    private Player playingUser;

    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    private void createGameQuestions() {
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
        Question questionLv1x1 = new Question("How high is the mountain Everest?", 1, answersQuestionLv1x1);

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
        answersQuestionLv3x0.add(new CorrectAnswer("10994m"));
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

    private boolean startMenuAndAskGuest() {
        System.out.println("$$$ WHO WANTS TO BE A MILLIONAIRE $$$");
        System.out.println("Y - PLAY GAME");
        System.out.println("N - QUIT GAME");
        if (getAnswerFromUser()) {
            accountMenu();
            return true;
        }
        return false;
    }

    private void accountMenu() {
        System.out.println("Y - to create a new account.");
        System.out.println("N - to login in an existing one.");
        if (getAnswerFromUser()) {
            players.add(getUserCredentials());
            System.out.println("Account successfuly created.");
        }
        userLogIn();
    }

    private void userLogIn() {
        if (checkUserCredentials(getUserCredentials())) {
            System.out.println(playingUser.getUsername() + " succesfully logged in.");
        } else {
            System.out.println("Wrong account or password, Y - try again / N - return to main loby.");
            if (!getAnswerFromUser()) {
                startMenuAndAskGuest();
            } else {
                userLogIn();
            }
        }
    }

    private boolean checkUserCredentials(Player playerToLogIn) {
        if (players.isEmpty()) {
            players.add(new Player("", ""));
        }
        for (Player player : players) {
            if (player.equals(playerToLogIn)) {
                playingUser = playerToLogIn;
                return true;
            }
        }
        return false;
    }

    private Player getUserCredentials() {
        System.out.println("Enter your username:");
        String username = scan.nextLine();
        System.out.println("Enter your pasword:");
        String password = scan.nextLine();
        return new Player(username, password);
    }

    private void setQuestionsForLevels() {
        for (int i = 1; i <= MAX_LEVEL; i++) {
            ArrayList<Question> gameQuestionsPerLevel = getQuestionsPerLevel(i);
            gameQuestionsInUse.add(gameQuestionsPerLevel.get(rand.nextInt(gameQuestionsPerLevel.size())));
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

    private boolean askForFiftyFifty() {
        System.out.println("Fifty fifty tries remaining: " + fiftyFiftyTries);
        System.out.println("Do you want to use fifty fifty on this question?(Y/N)");
        if (getAnswerFromUser()) {
            fiftyFiftyTries--;
            return true;
        }
        return false;
    }

    private boolean askForWithdraw() {
        System.out.println("Do you wish to continue? (Y/N)");
        if (!getAnswerFromUser()) {
            System.out.println("Congratulations you won the prize for level: " + currentLevel);
            return false;
        }
        return true;
    }

    private boolean askForNewGame() {
        System.out.println("Y - new game / N - quit");
        return getAnswerFromUser();
    }

    private boolean getAnswerFromUser() {
        boolean goodAnswer = false;
        do {
            String answer = scan.nextLine();
            switch (answer) {
                case "Y":
                case "y":
                    return true;
                case "N":
                case "n":
                    return false;
                default:
                    System.out.println("Incorrect input please use Y or N to choose.");
            }
        } while (!goodAnswer);
        return true;
    }

    private void gameReset() {
        currentLevel = 1;
        gameQuestionsInUse.clear();
        gameQuestions.clear();
        fiftyFiftyTries = 2;
        createGameQuestions();
    }

    private void setNewGame() throws IOException, InterruptedException {
        gameReset();
        setQuestionsForLevels();
        mainGameCourse();
    }

    private void mainGameCourse() throws IOException, InterruptedException {
        for (Question question : gameQuestionsInUse) {
            Collections.shuffle(question.getAnswerList());
            clearCmd();
            System.out.println("Game current level is: " + currentLevel);
            question.showQuestionAndAnswers();
            if (fiftyFiftyTries > 0) {
                boolean tryFiftyFifty = askForFiftyFifty();
                if (tryFiftyFifty) {
                    question.fiftyFifty();
                }
            }
            gameOver = question.answerQuestion();
            if (gameOver) {
                break;
            }
            if (currentLevel > MAX_LEVEL - 1) {
                System.out.println("CONGRATULATIONS YOU WON THE BIG PRIZE!!!");
                break;
            }
            gameOver = askForWithdraw();
            if (!gameOver) {
                break;
            }
            currentLevel++;
        }
    }

    void runGame() throws IOException, InterruptedException {
        boolean gameOn = startMenuAndAskGuest();
        while (gameOn) {
            setNewGame();
            gameOn = askForNewGame();
        }
    }

    private static void clearCmd() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
