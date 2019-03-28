import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginFactory {

    private static boolean isloggedin = false;
    private static ArrayList<User> users;

    public LoginFactory(ArrayList<User> users){
        users = this.users;
    }

    public static boolean login(String username, String password){
        User user = match_login(username,password);
        if(user!=null){
            isloggedin = true;
            showWelcomeMessage(user.getUsername());
            showDashboard(user);

            return true;
        }else{
            System.out.println("Wrong username/password");
            prompt_login();
            return false;
        }
    }

    private static void prompt_login(){
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

    private static String  prompt_username(){
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

    private static String prompt_password(){
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

    private static User match_login(String username, String password){
        User user = null;
        for(int i = 0; i < users.size(); i++) {
            if (username.equalsIgnoreCase(users.get(i).getUsername()) && password.equalsIgnoreCase(users.get(i).getPassword())){
                user = users.get(i);
                return user;
            }
        }
        return user;
    }

    private static void showWelcomeMessage(String username){
        System.out.print("Welcome " + username +"\n");
    }


}
