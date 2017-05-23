/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * @author JayO
 */
public class PythagoreanTripletFinder {
	private final int CAP = 1000; //The sum will be 1000, so really the max should be less than 1000
	/**
	 * Find a pythagorean triplet (a^2 + b^2 = c^2)
	 * Check the sum of the three components a, b, and c
	 * Print out the product abc
	 */
	public PythagoreanTripletFinder() {
		
		for(int a = 0; a < CAP; a++) { //For every a from 1 to 334
			for(int b = a + 1; b < CAP; b++) { //For every b from a to 334
				for(int c = b + 1; c < CAP; c++) { //For every c from b to 334
					if(isTriplet(a, b, c)){
						if(a + b + c == 1000) {
							//System.out.println("You've found it!"); //**TEST**
							System.out.println("The product is " + a*b*c);
							break;
						}
					}
				}
			}
		}
	}
	
	//If the first two terms squared then added is equivalent to the third, it is a triplet
	public boolean isTriplet(int a, int b, int c) {
		if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
			return true;
		else
			return false;
	}
}