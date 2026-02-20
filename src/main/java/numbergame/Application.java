package numbergame;
import java.util.Random;
import java.util.Scanner;


public class Application {
	
	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice, chances, min, max, randomNumber, play;
		String difficult;
		Random rand = new Random();
		min = 1;
		max = 100;
		randomNumber = rand.nextInt(max - min + 1) + min;
		
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("I'm thinking of a number between 1 and 100.\n");
		System.out.println("""
				Please select the difficulty level: 
				1. Easy (10 chances)
				2. Medium (5 chances)
				3. Hard (3 chances)
				""");
		System.out.print("Enter your choice: ");
		choice = INPUT.nextInt();
		
		switch (choice) {
			case 1 -> {
				chances = 10;
				difficult = "EASY";
			}
			case 2 -> {
				chances = 5;
				difficult = "MEDIUM";
			}
			case 3 -> {
				chances = 3;
				difficult = "HARD";
			}
			default -> throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		System.out.println("Great! You have selected the "+difficult+" difficulty level!");
		System.out.println("You have "+chances+" chances to guess the correct number!");
		System.out.println("Let's start the game!\n");
		int attempt = 0;
		
		do {
			System.out.print("Enter your guess: ");
			play = INPUT.nextInt();
			attempt++;
			chances--;
			
			if (play > randomNumber && chances > 0) {
				System.out.println("Incorrect! The number is less than "+play+".");
			}
			else if(play < randomNumber && chances > 0) {
				System.out.println("Incorrect! The number is greater than "+play+".");
			}
			else if (play == randomNumber){
				String haveS = "";
				if (attempt > 1) {
					haveS = "s";
				}
				System.out.println("Congratulations! You guessed the correct number in "+attempt+" attempt"+haveS+".");
			}
			else {
				System.out.println("I'm sorry! You lose.");
			}
		} while(play != randomNumber && chances > 0);
		
		
	}
}
