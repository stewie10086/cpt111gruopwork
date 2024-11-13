

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginSystem {
    //This is a login system

    /* We could define a 2 dimensional-array to store the accounts
       for example: Using Account[0][0] to store the account and Account[0][1] is used for storing password.
       that this run may be used.
       The second account will use Account[1][0] and Account[1][1] to represent.
     */
    int AccountNumber = 0;
    String[][] Accounts = new String[AccountNumber + 100][2];
    String[] NameStore = new String[AccountNumber + 100];
    Scanner sc = new Scanner(System.in);
    String fileName = "Users.csv";
    initiate it = new initiate();
    public void logInSystem() throws IOException {
        System.out.println("-------------------------------------");
        System.out.println("Welcome to the login system!");
        System.out.println("Notice: You must sign up your account first!!!");
        System.out.println("1.Log in");
        System.out.println("2.Sign up");
        System.out.println("3.Check your account");
        System.out.println("4.Exit");
        System.out.print("Enter your choice: ");
        while (true) {
            String option = sc.nextLine();
            switch (option) {
                //Log in
                case "1":
                    if (logIn()){
                    NextPage();
                    }else {
                        System.out.println("Your UserId or Password is incorrect. plz try again.");
                        logIn();
                    }

                    break;
                //2.Sign up
                case "2":
                    signUp();
                    AccountNumber++;
                    System.out.println("You have set up your account, now please log in ");
                    if (logIn()){
                        NextPage();
                    }
                    break;
                //3.Check your account
                case "3":
                    check();
                    break;
                //Exit
                case "4":
                    it.start();
                    return;
                default:
                    System.out.println("Your input is not valid, please try again");
            }
        }
    }

    public void signUp() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        readFile(fileName,users);

        System.out.println("Please input your UseId");
        while (true) {
            String UserId = sc.nextLine();
            boolean AccountExists = false;
            for (User user : users) {
                if (UserId.equals(user.getUserid())) {
                    System.out.println("The account has been signed up, Please change your account!");
                    //To avoid repeating account.
                    AccountExists = true;
                    break;

                }
            }
            if (!AccountExists) {
                Accounts[AccountNumber][0] = UserId;
                break;
            }
        }
        System.out.println("Please input your password");
        String PassWord = sc.nextLine();
        Accounts[AccountNumber][1] = PassWord;
        System.out.println("Congratulations! You have been signed up!");
        System.out.println("Now, set up your name: ");
        while (true) {
            String NameSet = sc.nextLine();
            boolean NameExists = false;
            for (int i = 0; i < users.size(); i++) {
                if (NameSet.equals(users.get(i).getUsername())) {
                    System.out.println("The name you entered already exists, please try again");
                    NameExists = true;
                    break;
                }
            }
            if (!NameExists) {
                System.out.println("You have set up your name.");
                NameStore[AccountNumber] = NameSet;

                break;
            }
        }

        users.add(new User(Accounts[AccountNumber][0], NameStore[AccountNumber], Accounts[AccountNumber][1]));
        writeFile(fileName,users);


    }

    public boolean logIn() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        readFile(fileName, users);
        if (users == null || users.isEmpty()) {
            System.out.println("Please sign up first!");
            return false;
        }
            System.out.println("Please input your UserId: ");
            String UserId = sc.nextLine();
            System.out.println("Please input your password: ");
            String PassWord = sc.nextLine();
            for (User user : users) {
                if (UserId.equals(user.getUserid()) && PassWord.equals(user.getPassword())) {
                    System.out.println("Successfully logged in!");
                    return true;


                }

            }
            return false;
    }
    public void check() {
        System.out.println("Please input your Username: ");
        String account = sc.nextLine();
        for (int i = 0; i < Accounts.length; i++) {
            if (i <= AccountNumber) {//To avoid null pointer exception
                if (account.equals(Accounts[i][0])) {
                    System.out.println("This account exists");
                } else break;
            }
        }
    }


    public static void readFile(String fileName, ArrayList<User> array) throws IOException {
        //创建输入缓冲流对象
        try {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            String[] Datas = line.split(",");
            User user = new User();
            user.setUserid(Datas[0]);
            user.setUsername(Datas[1]);
            user.setPassword(Datas[2]);


            array.add(user);
        }
        br.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }


    public static void writeFile(String fileName,ArrayList<User> array) throws IOException{
        //创建输出缓冲流
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0;i<array.size();i++){
            User user = array.get(i);
            StringBuilder sb = new StringBuilder();

            sb.append(user.getUserid()).append(",").append(user.getUsername()).append(",").append(user.getPassword());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();

       }
       public void NextPage() throws IOException {
            initiate initiate = new initiate();
            initiate.ifLogin = true;
            initiate.start();
        }
       }

