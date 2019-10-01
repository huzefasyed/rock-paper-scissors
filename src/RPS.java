import java.util.*;

public class RPS {
    // index 0: user points, index 1: computer points
    Integer[] points = {0, 0};
    // keys mapping to the value that is weaker
    Map<String, String> keys = new HashMap<>();

    public static void main(String[] args){
        // using try with resource
        try {
            RPS rps = new RPS();
            Scanner input = new Scanner(System.in);
            String userInput = "";
            do {
                System.out.println("\nChoose: Rock/Paper/Scissors");
                System.out.println("Or Alternatively Press Q to quit");
                userInput = input.next().toUpperCase();

                if(rps.isValid(userInput)){
                    // guesses and compares value of user and computer
                    rps.compare(userInput);
                }
                else {
                    if (userInput.equals("Q")) System.exit(1);
                    System.err.println("Invalid entry! Please enter Rock, Paper or Scissors.");
                }
            } while(!userInput.equals("Q"));
            // closing resource
            input.close();
        } catch (Exception e) {
            System.err.println("Error! " + e.toString());
        }
    }


    public RPS() {
        // mapping stronger to weaker
        keys.put("ROCK", "SCISSORS");
        keys.put("PAPER", "ROCK");
        keys.put("SCISSORS", "PAPER");
    }

    public boolean isValid(String userInput) {
        // checks if the key exists / is valid
        return keys.containsKey(userInput);
    }

    public void compare(String userInput) {
        String compGuess = this.getGuess();
        System.out.println("The computer chose: " + compGuess);

        if (compGuess.equals(userInput)) {
            System.out.println("It's a draw");
        }
        // if computer's guess is equal to the weaker value
        else if (keys.get(userInput).equals(compGuess)) {
            System.out.println("You win!");
            points[0]++;
        }
        else {
            System.out.println("Computer wins!");
            points[1]++;
        }
        System.out.println("Your point is: " + points[0]);
        System.out.println("Computer's point is: " + points[1] + "\n");
    }

    private String getGuess() {
        Random rand = new Random();    
        // converts keys to an array in order to access an element with a random number
        Object[] guesses = keys.keySet().toArray();
        return guesses[rand.nextInt(3)].toString();
    }
}
