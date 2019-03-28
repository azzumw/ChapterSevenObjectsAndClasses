import java.util.ArrayList;

public class Mailbox {
    private ArrayList<Message> messageArrayList;

    public Mailbox() {
        messageArrayList = new ArrayList<>();
    }

    public void addMessage(Message message){
        messageArrayList.add(message);
    }

    public Message getMessage(int i){
        if(!messageArrayList.isEmpty()){
            return messageArrayList.get(i);
        }else return null;
    }

    public void removeMessage(int i){
        if(!messageArrayList.isEmpty()){
            messageArrayList.remove(i);
        }
    }

    public ArrayList<Message> getMessageArrayList(){
        return messageArrayList;
    }

    public int getNumberOfMessages(){
        return messageArrayList.size();
    }
}
