import java.util.*;

public class SumSquare {

	/**
	 * method description:
	 * Finds the difference between the sum of the squares of 
	 * the inputed natural numbers and the square of the sum.
	 */
	public SumSquare() {
		System.out.println("Enter a number you want to calculate.");
		Scanner scan = new Scanner(System.in);
		
		double input = scan.nextDouble();
		double sumSquared = 0, squaredSum = 0; //Great names right?
		
		for(int i = (int) input; i > 0; i--) {
			sumSquared += i;
			squaredSum += Math.pow(i, 2);
		}
		sumSquared = (int) Math.pow(sumSquared, 2);
		
		System.out.println("The sum squared is " + sumSquared + " and the squared sum is " + squaredSum);
		
		System.out.println("The difference between the sum of the squares and the square of the sum is "
				+ (sumSquared - squaredSum));
	}
	
	
}
