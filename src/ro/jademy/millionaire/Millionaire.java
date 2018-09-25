package ro.jademy.millionaire;

public class Millionaire {
    public static void main(String[] args) {

        Game game = new Game();
        boolean gameOn;
        game.mainMenu();
        do {
            game.setQuestionsForLevels();
            for (Question question : game.getGameQuestionsInUse()) {
                question.showQuestion();
                if (game.getFiftyFiftyTries() > 0) {
                    boolean isFiftyFifty = game.askForFiftyFifty();
                    if (isFiftyFifty) {
                        question.fiftyFifty();
                    }
                }
                game.setGameOver(question.answerQuestion());
                if (game.getGameOver()) {
                    break;
                }
                game.askForWithdraw();
            }
            gameOn = game.endMenu();
        } while (gameOn);
    }
}
