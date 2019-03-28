import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MailboxTest {

    Message message;
    Mailbox mailbox;
    String messageText;
    @Before
    public void setData(){
        messageText = "Hey hannah!";
        message = new Message("recipient","sender");
        message.append(messageText);
        mailbox = new Mailbox();
        mailbox.addMessage(message);

    }
    @Test
    public void addMessage() {
//        mailbox.addMessage(message);
        assertTrue("true",mailbox.getNumberOfMessages()>0);
    }

    @Test
    public void getMessage() {
        String  msgText = mailbox.getMessage(0).getMessageText();
        assertEquals(messageText+" ",msgText);
    }


    @Test
    public void removeMessage() {
        mailbox.removeMessage(0);
        assertTrue("true",mailbox.getNumberOfMessages()==0);
    }
}