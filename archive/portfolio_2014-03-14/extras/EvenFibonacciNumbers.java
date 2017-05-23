import java.util.*;

/**
 * Finds the sum of the even Fibonacci numbers from 1 to four million
 * @author JayO
 */

public class EvenFibonacciNumbers {

	public EvenFibonacciNumbers() {
		Scanner scan = new Scanner(System.in);
		
		int toCountTo = 4000000;
		
		int previousTerm, currentTerm, holder, totalSum;
		previousTerm = currentTerm = 1;
		
		holder = totalSum = 0;
		
		//While the number in the fibonacci sequence doesn't exceed four million
		while(currentTerm < toCountTo) {
			//Store the value of the next number in the sequence
			holder = previousTerm + currentTerm;
			
			//Update values
			previousTerm = currentTerm;
			currentTerm = holder;
			
			//Print out the current sum of the numbers **TEST**
			//System.out.println("The current sum is " + holder);
			
			//If the Fibonacci number sequence is even, add it to the sum
			if(holder % 2 == 0)
				totalSum += holder;
			
			System.out.println("The total sum is " + totalSum);
			
		}
	}
}
