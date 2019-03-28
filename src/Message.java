public class Message {
    private String recipient;
    private String sender;
    private String messageText;

    public Message(String recipient, String sender) {
        this.recipient = recipient;
        this.sender = sender;
        messageText="";
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void append(String messageText) {
        this.messageText+=messageText+" ";
    }

    @Override
    public String toString() {
        String from = "From: " + this.sender + "\n";
        String to = "To: " + this.recipient + "\n";


        return from + to + this.messageText;
    }
}
