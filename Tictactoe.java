//Ugly code for a Tic Tac Toe game, but it works. I'm sure there are better ways to do this, but I'm still learning ;)
import java.util.Scanner;

public class test {

    public static boolean played;
    
    
    public static boolean check(String[] cases){
        for(int i = 0; i<3; i++){
            if(cases[i] == cases[i+3] && cases[i+3] == cases[i+6] && cases[i] != " "){
                return true;
            }
        }
        for(int i = 0; i<9; i+=3){
            if(cases[i] == cases[i+1] && cases[i+1] == cases[i+2] && cases[i] != " "){
                return true;
            }
        }
        if(cases[0] == cases[4] && cases[4] == cases[8] && cases[0] != " "){
            return true;
        }
        if(cases[2] == cases[4] && cases[4] == cases[6] && cases[2] != " "){
            return true;
        }

        return false;
    }



    public static void board(String[] cases){
        System.out.println("Here is the board:");
            System.out.printf(" %s | %s | %s ", cases[0]==" "? "1":cases[0], cases[1]==" "? "2":cases[1], cases[2]==" "? "3" :cases[2]);
            System.out.println("\n-----------");
            System.out.printf(" %s | %s | %s ", cases[3]==" "? "4":cases[3], cases[4]==" "? "5":cases[4], cases[5]==" "? "6" :cases[5]);
            System.out.println("\n-----------");
            System.out.printf(" %s | %s | %s \n", cases[6]==" "? "7":cases[6], cases[7]==" "? "8":cases[7], cases[8]==" "? "9" :cases[8]);
    }
    
    
    
    public static void play(String h, String[] cases, int playerChoice){
        if(cases[playerChoice-1] == " "){
            cases[playerChoice-1] = h;
            played = true;
        }else{
            System.out.println("This space is already taken, please choose another one.");
        }
    }



    public static void main(String[] args) {
        String[] cases = new String[9];
        for(int i = 0; i < 9; i++) {
            cases[i] = " ";
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1 is X, Player 2 is O");
        System.out.println("Player 1, please enter your name: ");
        String player1 = sc.nextLine();
        System.out.println("Player 2, please enter your name: ");
        String player2 = sc.nextLine();
        System.out.println("Let's play!");
        int playerChoice;
        while(true){
            played = false;
            while(!played){
                board(cases);
                System.out.println(player1 + ", in what space would you like to place your X ?");
                playerChoice = sc.nextInt();
                play("X", cases, playerChoice);
            }
            if(check(cases)){
                board(cases);
                System.out.printf("Congrats %s, you won!", player1);
                break;
            }
            played = false;
            while(!played){
                board(cases);
                System.out.println(player2 + ", in what space would you like to place your O ?");
                playerChoice = sc.nextInt();
                play("O", cases, playerChoice);
            }
            if(check(cases)){
                board(cases);
                System.out.printf("Congrats %s, you won!", player2);
                break;
            }
        }
    }
}
