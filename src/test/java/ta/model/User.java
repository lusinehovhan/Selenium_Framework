package ta.model;

import java.util.Objects;

public class User {

    private String username;
    private String useremail;
    private String password;


    public User(String username, String useremail, String password) {
        this.username = username;
        this.useremail = useremail;
        this.password = password;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && useremail.equals(user.useremail) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, useremail, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
