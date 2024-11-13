import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


    public class initiate {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        String fileName = "Users.csv";
        boolean ifLogin = false;
        public void start() throws IOException {
                System.out.println("Welcome to our page, here are the selections for you");
                System.out.println("1.Log in or sign up");
                System.out.println("2.Topic selection");
                System.out.println("3.Quiz taking");
                System.out.println("4.User dashboard");
                System.out.println("5.Leaderboard");
                System.out.println("6.Exit");
                System.out.print("Enter your choice: ");
                while (true) {
                String number = sc.nextLine();
                //input the option user chooses
                switch (number) {
                    //Log in or sign up
                    case "1":
                        if (ifLogin){
                            System.out.println("You have logged in, now begin to choose topic!");
                            continue;
                        }
                        LoginSystem lgs = new LoginSystem();
                        lgs.logInSystem();
                        continue;
                    //Topic selection
                    case "2":


                        continue;
                    //Start your Answer attempt
                    case "3":

                        continue;
                    //User dashboard
                    case "4":

                        continue;
                    //Leaderboard
                    case "5":

                        continue;
                    //Exit
                    case "6":
                        return ;
                    default:{
                        System.out.println("Your input is not valid, please try again");}

                }
            }
        }
        public void readFile() throws IOException {
            LoginSystem.readFile(fileName,users);
        }
    }

