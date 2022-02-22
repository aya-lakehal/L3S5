package utils;

/**
 * An abstract class who check if numbers are power of 2.

 * 
 */
public abstract class Maths {
	
	/**
	 * Test if x is a power of 2.
	 * @param x int
	 * @return true if x is a power of 2, false otherwise.
	 */
	public static boolean isPowerOf2(int x) {
		return x != 0 && ((x & (x - 1)) == 0);
	}

}
