import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MailboxSystem {

    private ArrayList<User> users;
    boolean isloggedin =false;

    public MailboxSystem() {
        this.users = new ArrayList<>();
        mainMenu();
    }


    private boolean login(String username, String password){
//        User user = match_login(username,password);
//          if(user!=null){
//              isloggedin = true;
//                  showWelcomeMessage(user.getUsername());
//                  showDashboard(user);
//
//              return true;
//          }else{
//              System.out.println("Wrong username/password");
//              prompt_login();
//              return false;
//          }
        return LoginFactory.login(username,password);
    }

    private void prompt_login(){
        boolean done = false;
        do{
            try {
                System.out.println("Please enter your login details:");
                String username = prompt_username();
                String password = prompt_password();
                done = login(username, password);

            }catch (InputMismatchException e){
                System.out.println("Input invalid,please try again");
            }

        }while (!done);
    }

    private String  prompt_username(){
        boolean done = false;
        String username = null;
        do{
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("Username: ");
                username = in.next();
                done = true;

            }catch (InputMismatchException e){
                System.out.println("Invalid input,please try again");
            }
        }while (!done);
      return username;
    }

    private String prompt_password(){
        boolean done = false;
        String password = null;
        do{
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("Password: ");
                password = in.next();
                done = true;


            }catch (InputMismatchException e){
                System.out.println("Invalid input,please try again");
            }
        }while (!done);
        return password;
    }



    private void showDashboard(User user) throws InputMismatchException {
        if(isloggedin){
            String [] options = {"Read Messages","Write a message","Quit/Logout"};

            Scanner in = new Scanner(System.in);
            int input;
            try{
                do{
                    for(int i = 0; i < options.length; i ++){
                        System.out.println(i + ") "+ options[i]);
                    }

                    System.out.println("Enter option number: ");
                    input = in.nextInt();
                    if (input==0){
                        ArrayList<Message> messages = user.getMailbox().getMessageArrayList();
                        if(messages.isEmpty()){
                            System.out.println("No messages to display");
                            showDashboard(user);
                        }else {
                            for(int i =0; i< messages.size(); i++){
                                System.out.println(i + "] "+ messages.get(i).getSender());
                            }
                            boolean done = false;
                            do {

                                try {

                                    Scanner scanner = new Scanner(System.in);
                                    System.out.println("Enter option: ");
                                    int option = scanner.nextInt();
                                    if(option>=0 && option<messages.size()){
                                        done = true;
                                        String message = messages.get(option).toString();
                                        System.out.println(message);
                                        showDashboard(user);
                                    }

                                    else {
                                        System.out.println("enter between 0 and ");
                                        System.out.print(messages.size()-1);
                                    }

                                }catch (InputMismatchException e){
                                    System.out.println("Please enter option number.");
                                }
                            }while (!done);
                        }
                    }
                    else if(input==1){
                        //choose recipient
                        Scanner scanner = new Scanner(System.in);
                        String recipient;
                        boolean user_found = false;

                        do {
                            System.out.println("Recipient: ");
                            recipient = scanner.next();
                            user_found = check_user(recipient);
                        }while (!check_user(recipient));

                        if(user_found){
                            User recip = getUser(recipient);
                            Message message = new Message(recip.getUsername(),user.getUsername());
                            Scanner scanner1 = new Scanner(System.in);
                            String messageText = scanner1.nextLine();
                            message.append(messageText);
                            //add message to recipient mailbox
                            recip.getMailbox().addMessage(message);
                            System.out.println("Message sent!");
//                            System.out.println(users.get(1).getMailbox().getMessage(0).getMessageText());
                            showDashboard(user);
                        }
                    }
                    //logout
                    else if(input == 2){
                        logout();
                    }

                }while (input <0 || input >= 3);
            }
            catch (InputMismatchException imm){
                System.out.print("illegal arguments");
            }
        }
    }



    private void showWelcomeMessage(String username){
        System.out.print("Welcome " + username +"\n");
    }

    private User match_login(String username, String password){
        User user = null;
        for(int i = 0; i < users.size(); i++) {
            if (username.equalsIgnoreCase(users.get(i).getUsername()) && password.equalsIgnoreCase(users.get(i).getPassword())){
                user = users.get(i);
                return user;
            }
        }
        return user;
    }

    private boolean check_user(String username){
        for(int i = 0; i < users.size(); i++) {
            if (username.equalsIgnoreCase(users.get(i).getUsername())){
                return true;
            }
        }

        return false;
    }

    private User getUser(String username)
    {
        User user = null;
        for(int i = 0; i < users.size(); i++) {
            if (username.equalsIgnoreCase(users.get(i).getUsername())){
                user = users.get(i);
            }
        }
        return user;
    }


    protected void registerUser(){
        Scanner in = new Scanner(System.in);
        boolean done = false;
        //prompt for username
        do{
            System.out.println("Enter username: ");
            String username = in.next();
            done = check_user(username);
            if(!done){
                Scanner o = new Scanner(System.in);
                System.out.println("Enter password: ");
                String pass  = o.next();
                User user = new User(username,pass,new Mailbox());
                users.add(user);
                System.out.println("Congratulations! "+ username + " username has been created");
                isloggedin =true;
                showDashboard(user);
            }else {
                System.out.println("Username already exists, choose another.");
            }
        }while (done);
        //check if this username already exists
        //            //if it does, inform the user and re-prompt the user.
        //            //else create a user object.

    }

    public void showUsers() {
        if(!users.isEmpty()){
            for (User user: users) {
                System.out.println(user.getUsername());
            }
            mainMenu();
        }else {
            System.out.println("no users exists");
            mainMenu();
        }
    }

    public void mainMenu(){
        String [] main_option = {"Login","Register","Users","Exit"};
        boolean done = false;

        do{
            try {
                Scanner s = new Scanner(System.in);
                printMainDash(main_option);
                System.out.println("Enter option: ");
                int input = s.nextInt();
                if(input>=0 && input<4){
                    router(input);
                    done = true;
                }else {
                    System.out.println("enter between 0 and 2");
                }

            }catch (InputMismatchException e){
                System.out.println("Mismatch");
            }

        }while (!done);
    }

    private  void printMainDash(String [] array){
        for(int i = 0; i <array.length; i++){
            System.out.println(i + ") " + array[i]);
        }
    }

    private  void router(int i){
        switch (i){
            case 0: this.prompt_login(); break;
            case 1: this.registerUser(); break;
            case 2: this.showUsers(); break;
            case 3: System.exit(0); break;
        }
    }

    private void logout(){
        isloggedin = false;
        mainMenu();
    }

}
