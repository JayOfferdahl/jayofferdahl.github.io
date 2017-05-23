/**
 * @author Jay Offerdahl
 * Create a stack that holds all the prime numbers
 * Start from 1 and go to infity looking for prime numbers
 * When the stack is at the desired element (nth prime number) pop the stack and print the result
 */

import java.util.*;

public class FindAPrime {

	public FindAPrime() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the value for n to find the nth prime number.");
		int primeToFind = scan.nextInt();
		
		Stack<Double> primeHolder = new Stack<Double>();
		double currentNumber = 2;
		
		//While the size of the prime number stack isn't the number of the prime number desired
		while(primeHolder.size() != primeToFind) {
			//If the factors list is <= 1 add the currentNumber to the list (it's prime)
			if(findFactors(currentNumber).getSize() <= 1)
				primeHolder.push(currentNumber);
			currentNumber++;
		}
		
		//Print out the output
		System.out.println("The " + primeToFind + "st prime number is " + primeHolder.pop());
	}
	
	/**
	 * Finds all the factors of the given input (double) and stores them in a DynamicIntList
	 * @param input - number to find the factors of
	 * @return allFactors - a DynamicIntList containing all the factors of input
	 */
	public DynamicIntList findFactors(double input) {
		DynamicIntList allFactors = new DynamicIntList();
		
		for(int i = 1; i <= input/i; i++) {
			if(input % i == 0)
				allFactors.add(i);	
		}
		
		return allFactors;
	}
}
