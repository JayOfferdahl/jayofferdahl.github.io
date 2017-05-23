import java.util.Scanner;

public class SmallestMultiple {

	public SmallestMultiple() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number.");
		int input = scan.nextInt();
		
		System.out.println("Finding the smallest multiple of all the numbers from 1 to " + Integer.toString(input) + ".");
		
		boolean notFound = true;
		int answer;
		double divisor = input, currentNumber = 1;
		
		//While you have not received a value of 1 from checkIfDivisible (see method description)
		while(notFound) {
			answer = checkIfDivisible(currentNumber, divisor);
			
			if(answer == -1) {
				//Increase the number you want to check by 1
				currentNumber++;
			}
			else if(answer == 1) {
				for(int i = 3; i > 0; i--)
					System.out.println(".");
				System.out.println("The smallest multiple of all the numbers from 1 to " + Integer.toString(input) + " is " + currentNumber);
				notFound = false;
			}
		}
	}
	
	/**
	 * Returns an integer number -1, 0, or 1 to see whether the current number is evenly
	 * divisible by the number, not divisible by the number, or 
	 * @param number defines the current number you are attempting to find the divisor of
	 * @param divisor defines the divisor that you are using on the number
	 * @return -1 if the number is not divisible by the divisor
	 * 			1 if the divisor is 0, meaning the number is divisible by all numbers
	 */
	public int checkIfDivisible(double number, double divisor) {
		if(divisor == 0) {
			return 1;
		}
		/*
		 * Recursion -- start with the highest divisor and go down until 0
		 * Should return 1 if all the numbers are divisible by it
		 */
		else if(number % divisor == 0) {
			return checkIfDivisible(number, divisor - 1);
		}
		else {
			return -1;
		}
	}	
}