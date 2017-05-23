/**
 * @author Jay Offerdahl
 * 
 * Finds the largest palidrome that is the product of two three digits numbers
 */

import java.util.*;


public class LargestPalindromeProject {
	private final int MAX_PRODUCT = 998001;
	private int one, two;
	
	public LargestPalindromeProject() {
		System.out.println("Finding the largest palindrome as a result of two three digit numbers.");
		Stack<Integer> palindromeStack = new Stack<Integer>();
		
		//Find a palindrome between 1 and 998001 MAX_PRODUCT
		for(int i = 0; i < MAX_PRODUCT; i++) {
			if(isPalindrome(i)) 
				palindromeStack.add(i);
		}
		
		int index = palindromeStack.size();
		int currentElement = 0;
		
		while(index > 0) {
			currentElement = palindromeStack.pop();
			if(hasTwoThreeDigits(findFactors(currentElement), currentElement)) {
				System.out.println("The largest palindrome as a product of two three digit numbers is: " + currentElement);	
				System.out.println("The numbers are " + one + " and " + two);
				break;
			}
			index--;
		}
	}
	
	//Tests if the int is a palindrome
	public boolean isPalindrome(int num) {
		boolean palindrome = true;
				
		int holderNum = num;
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		while(holderNum > 0) {
			stack.push(holderNum % 10);
			holderNum /= 10;
		}
		
		int[] digits = new int[stack.size()];
		int stackCount = stack.size();
		
		for(int i = 0; i < stackCount; i++) {
			digits[i] = stack.pop();
		}
		
		for(int index = 0; index < digits.length / 2; index++) {
			if(index == digits.length - (index + 1)) {
				palindrome = true;
				break;
			}
			else if(!(digits[index] == digits[digits.length - (index + 1)])) {
				palindrome = false;
				break;
			}
			else {
				//Keep going
			}
		}
		return palindrome;
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
	
	//Find the number of digits in a given input (2342 has four)
	public int getDegree(int input) {
		int numStorage = input;
		int degree = 0;
		
		while(numStorage > 0) {
			numStorage /= 10;
			degree++;
		}
		return degree;
	}
	
	public boolean hasTwoThreeDigits(DynamicIntList dynamicIntList, int inputNumber) {
		boolean twoThreeDigits = false;
		
		int degree;
		for(int index = 0; index < dynamicIntList.getSize(); index++) {
			
			//If the number of digits of the current index is not 3, do nothing
			degree = getDegree(dynamicIntList.get(index));
			if(degree != 3);
			else {
				//If the factor pair also has a digit count of 3, you found it
				degree = getDegree(inputNumber / dynamicIntList.get(index));
				if(degree == 3) {
					twoThreeDigits = true;
					one = dynamicIntList.get(index);
					two = inputNumber / dynamicIntList.get(index);
					break;
				}
			}
		}
		return twoThreeDigits;
	}
}