public class User {
    private String Userid;
    private String Username;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    private String Password;

    public User(String Userid, String Username, String Password) {
        this.Userid = Userid;
        this.Username = Username;
        this.Password = Password;

    }
    public User(){

    }


}
