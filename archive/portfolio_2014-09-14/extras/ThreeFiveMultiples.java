import java.util.*;

/**
 * Go through the numbers 1 to input
 * If the current number is divisible by 3 or 5, add it to the sum
 * Print out the total sum
 * @author JayO
 *
 */
public class ThreeFiveMultiples {

	public ThreeFiveMultiples() {
		System.out.print("Enter a number to count to: ");
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		int sum = 0;
		
		for(int i = 1; i <= input; i++) {
			if(i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		
		System.out.println("The total sum is " + sum);
	}
}