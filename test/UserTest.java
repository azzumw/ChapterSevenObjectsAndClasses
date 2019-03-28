import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class UserTest {
    private User user;
    private Mailbox mailbox;


    @Before
    public void setUp() throws Exception {
        mailbox = new Mailbox();
        user = new User("User","password",mailbox);
    }

    @Test
    public void getUsername() {
        String username = user.getUsername();
        assertEquals("User",username);
    }

    @Test
    public void setUsername() {
        user.setUsername("New");
        assertEquals("New",user.getUsername());
    }

    @Test
    public void getPassword() {
        String password = user.getPassword();
        assertEquals("password",password);
    }

    @Test
    public void setPassword() {
        user.setPassword("P@55word");
        assertEquals("P@55word",user.getPassword());
    }

    @Test
    public void getMailbox() {
        assertEquals(mailbox,user.getMailbox());
        System.out.println("Local: "+ mailbox);
        System.out.println(user.getMailbox());
    }

}