public class User {
    private String username;
    private String password;
    private Mailbox mailbox;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Mailbox mailbox) {
        this.username = username;
        this.password = password;
        this.mailbox = mailbox;
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

    public Mailbox getMailbox() {
        return mailbox;
    }

    public void setMailbox(Mailbox mailbox) {
        this.mailbox = mailbox;
    }
}
