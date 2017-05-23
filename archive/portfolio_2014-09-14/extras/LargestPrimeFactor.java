/**
 * @author Jay Offerdahl
 * Finds the largest prime number factor of the given integer input.
 * Uses a DynamicIntList to hold all of the factors of the given input
 * and hold the prime numbers contained in the factor DynamicIntList
 */
import java.util.*;

public class LargestPrimeFactor {

	public LargestPrimeFactor() {
		//Retreive user input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number to find the largest prime factor of ");
		double input = scan.nextDouble();
		
		//Find and store all of the factors of the given input
		DynamicIntList factorHolder = findFactors(input);
		
		//Print out the factors **TEST**
		/*
		System.out.println("All the factors: ");
		for(int u = 0; u < factorHolder.getSize(); u++)
			System.out.println(factorHolder.get(u));
		*/
		
		//Find the prime numbers that are also factors of the input
		DynamicIntList primeHolder = findPrimes(factorHolder);
		
		//Print out the prime number factors **TEST**
		/*
		for(int i = 0; i < primeHolder.getSize(); i++)
			System.out.println("The Prime Factors are: " + primeHolder.get(i));
		*/
		
		//Find the largest prime factor using a simple maximum finder
		int largestPrime = 0;
		
		for(int index = 0; index < primeHolder.getSize(); index++) {
			if(primeHolder.get(index) > largestPrime)
				largestPrime = primeHolder.get(index);
		}
		
		//Print out the final output to the console
		System.out.println("The largest prime factor to " + input + " is " + largestPrime);
	}
	
	/**
	 * Finds all the factors of the given input (double) and stores them in a DynamicIntList
	 * @param input - number to find the factors of
	 * @return allFactors - a DynamicIntList containing all the factors of input
	 */
	public DynamicIntList findFactors(double input) {
		DynamicIntList allFactors = new DynamicIntList();
		
		boolean firstFactor = true;
		int highestPossibleFactor = (int) input;
		
		/**
		 * Check every integer from 1 to the factor pair of the first found factor in order
		 * to save pointless steps after the loop has passed all possible factors
		 * e.g. Finding factors of 100 after passing 50
		 */
		for(int i = 1; i <= highestPossibleFactor; i++) {
			if(input % i == 0) {
				allFactors.add(i);
				if(i != 1 && firstFactor) {
					highestPossibleFactor = (int) (input/i);
					firstFactor = false;
				}
			}	
		}
		
		return allFactors;
	}
	
	/**
	 * Finds the prime numbers in the given input of assumed factors
	 * @param allTheFactors - DynamicIntList storing presumed factors of a number
	 * @return primeHolder - DynamicIntList containing all the prime factors found
	 */
	public DynamicIntList findPrimes(DynamicIntList allTheFactors) {
		DynamicIntList primeHolder = new DynamicIntList();
		
		for(int i = 0; i < allTheFactors.getSize(); i++) {
			if(findFactors((int) allTheFactors.get(i)).getSize() <= 2) 
				primeHolder.add(allTheFactors.get(i));
		}
		return primeHolder;
	}
}