import java.util.Scanner;
public class Day {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Player One: \nEnter Secret Word : ");
		
		String Day = kb.next();
		
		
		System.out.print("Player Two: \nEnter Your Guess:");
		
		String DayGuess = kb.next();
		int countr=0;
		while(!Day.equalsIgnoreCase(DayGuess)) {
		
			System.out.print("Wrong! Guess again:");
			DayGuess = kb.next();
			countr++;
		}
		
		System.out.print("You Are Correct. It was "+Day+"! It took you "+countr+" Guesses.");
		
		
		
	}
}