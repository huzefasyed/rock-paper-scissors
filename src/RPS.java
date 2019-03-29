import java.util.Scanner;
import java.util.Random;

public class RPS {
    int compPoints = 0;
    int userPoints = 0;



    public static void main(String[] args){
        RPS rps = new RPS();
        Random rand = new Random();
        String compGuess[]= {"ROCK", "PAPER", "SCISSORS"};
        Scanner input = new Scanner(System.in);
        String userInput;
        do{
            System.out.println("\nChoose: Rock/Paper/Scissors");
            System.out.println("Or Alternatively Press Q to quit");
            userInput = input.next().toUpperCase();

            if(userInput.contains("ROCK") || userInput.contains("PAPER") || userInput.contains("SCISSORS")){
                String rand1 = compGuess[rand.nextInt(3)];
                System.out.println("The Computer has chosen: " + rand1);
                rps.compare(userInput, rand1);
            }
            else {
                System.err.println("Invalid entry! Please enter Rock, Paper or Scissors.");
            }
        }while(!userInput.equals("Q"));
    }

    private void compare(String userInput, String rand1) {
        if (userInput.contains("ROCK")) {
            if(rand1 == "PAPER"){
                System.out.println("You Lose");
                compPoints++;

            }
            else if (rand1 == "SCISSORS"){
                System.out.println("You win");
                userPoints++;
            }
            else {
                System.out.println("It's a draw");
            }

        }
        else if (userInput.contains("PAPER")){
            if(rand1 == "ROCK"){
                System.out.println("You win");
                userPoints++;

            }
            else if (rand1 == "SCISSORS"){
                System.out.println("You lose");
                compPoints++;

            }
            else {
                System.out.println("It's a draw");
            }
        }
        else if(userInput.contains("SCISSORS")){
            if(rand1 == "PAPER"){
                System.out.println("You win");
                userPoints++;
            }
            else if(rand1 == "ROCK"){
                System.out.println("You lose");
                compPoints++;
            }
            else{
                System.out.println("It's a draw");
            }
        }
        System.out.println("Your points is: " + userPoints);
        System.out.println("Computer points is: " + compPoints+ "\n");
    }

}
