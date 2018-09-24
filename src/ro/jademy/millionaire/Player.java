package ro.jademy.millionaire;

public class Player {
    String username;
    String password;

    Player (String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername () {return username;}

    public String getPassword () {return password;}
}
