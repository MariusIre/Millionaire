package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String username;
    private String password;
    private ArrayList<GamePlayed> gamesPlayed = new ArrayList<>();

    Player (String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername () {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(username, player.username) &&
                Objects.equals(password, player.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
