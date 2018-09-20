package ro.jademy.millionaire;

public class Millionaire {
    public static void main(String[] args) {

        Game game = launchGame();
        game.mainMenu();
        do {
            Question question = game.setQuestion();
            game.gameNotOver = game.answerQuestion(question);
            game.showGameOver(game.gameNotOver);
        } while (game.gameNotOver);
        game.endMenu();
    }

    static Game launchGame() {
        Question question = new Question();
        question.difficultyLevel = 1;
        question.questionSentence = "This is a test dif1v1?";
        question.answerList.add(new Answer("test1",false));
        question.answerList.add(new Answer("test2",false));
        question.answerList.add(new Answer("test3",false));
        question.answerList.add(new Answer("test4",true));

        Question question1 = new Question();
        question1.difficultyLevel = 1;
        question1.questionSentence = "This is a test dif1v2?";
        question1.answerList.add(new Answer("aaa",false));
        question1.answerList.add(new Answer("bbb",false));
        question1.answerList.add(new Answer("ccc",false));
        question1.answerList.add(new Answer("ddd",true));

        Question question2 = new Question();
        question2.difficultyLevel = 2;
        question2.questionSentence = "This is the second dif2v1?";
        question2.answerList.add(new Answer("test10",false));
        question2.answerList.add(new Answer("test20",false));
        question2.answerList.add(new Answer("test30",false));
        question2.answerList.add(new Answer("test40",true));

        Question question3 = new Question();
        question3.difficultyLevel = 2;
        question3.questionSentence = "This is the second dif2v2?";
        question3.answerList.add(new Answer("test10",false));
        question3.answerList.add(new Answer("test20",false));
        question3.answerList.add(new Answer("test30",false));
        question3.answerList.add(new Answer("test40",true));

        Question question4 = new Question();
        question4.difficultyLevel = 3;
        question4.questionSentence = "This is the third test?";
        question4.answerList.add(new Answer("test10",false));
        question4.answerList.add(new Answer("test20",false));
        question4.answerList.add(new Answer("test30",false));
        question4.answerList.add(new Answer("test40",true));

        Game game = new Game();
        game.gameQuestions.add(question);
        game.gameQuestions.add(question1);
        game.gameQuestions.add(question2);
        game.gameQuestions.add(question3);
        game.gameQuestions.add(question4);

        return game;
    }

}
