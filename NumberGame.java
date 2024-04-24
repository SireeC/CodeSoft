import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min_range = 1;
        int max_range = 100;
        int attempts_limit = 6;
        int rounds = 0;
        int total_attempts = 0;
        
        System.out.println("Welcome to the Number_Guessing_Game!");
        
        boolean play_again = true;
        while (play_again)
	{
            int generated_number = random.nextInt(max_range - min_range + 1) + min_range;
            System.out.println("\nRound " + (rounds + 1) + ": Guess the number between " + min_range + " and " + max_range);
            
            int attempts = 0;
            boolean guessed_correctly = false;
            
            while (!guessed_correctly && attempts < attempts_limit)
	    {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                total_attempts++;
                
                if (guess == generated_number)
		{
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessed_correctly = true;
                }
		else if (guess < generated_number)
		{
                    System.out.println("too low!Try again.");
                }
		else
		{
                    System.out.println("too high! Try again.");
                }
            }
            
            if (!guessed_correctly)
	    {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generated_number);
            }
            
            rounds++;
            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String play_choice = scanner.next();
            
            if (!play_choice.equalsIgnoreCase("yes")) {
                play_again = false;
            }
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Total attempts: " + total_attempts);
        
        scanner.close();
    }
}
