import java.util.ArrayList;
import java.util.Stack;


/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * @author Jay Offerdahl
 */
public class SummationOfPrimes {

	public SummationOfPrimes() {
		Stack<Double> primeHolder = new Stack<Double>();
		double currentNumber = 2;
		
		while(currentNumber < 2000000) {
			if(findFactors(currentNumber).size() <= 1) {
				primeHolder.push(currentNumber);
				System.out.println(currentNumber);
			}
			currentNumber++;
		}
		
		double sum = 0;
		
		while(primeHolder.size() > 0) {
			sum += primeHolder.pop();
		}
		System.out.println("The sum of all primes lower than 2000000 is " + sum);
	}
	
	/**
	 * Find all the factors of the input (Integer values only)
	 * @param input: number you want to find the factors of
	 * @return allFactors: ArrayList of all the factors
	 */
	public ArrayList<Integer> findFactors(double input) {
		ArrayList<Integer> allFactors = new ArrayList<Integer>();
		
		for(int i = 1; i <= input/i; i++) {
			if(input % i == 0) {
				allFactors.add(i);
			}
		}
		
		return allFactors;
	}
}