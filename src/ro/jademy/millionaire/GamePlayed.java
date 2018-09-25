package ro.jademy.millionaire;

import java.util.Date;

public class GamePlayed {
    private int gameId;
    private Date date;
    private boolean wasGameWon;
    private int endLevel;

    GamePlayed(int gameId, Date date, boolean wasGameWon , int endLevel) {
        this.gameId = gameId;
        this.date = date;
        this.wasGameWon = wasGameWon;
        this.endLevel = endLevel;
    }
}