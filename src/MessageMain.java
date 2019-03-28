public class MessageMain {

    public static void main(String [] arg){

        Message message = new Message("Azzum","Anam");
        message.append("Hello, this azzum emailing");
        message.append("How are you?");
        System.out.println(message.toString());

    }

}
