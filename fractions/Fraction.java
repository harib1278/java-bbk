package fractions;

import java.math.*;

/**
 * Immutable fractions of whole numbers, also known as rational numbers,
 * with their usual arithmetic operations.
 * 
 * Similar to java.lang.BigInteger, the documentation uses pseudo-code
 * throughout the descriptions of Fraction methods. The pseudo-code
 * expression (i + j) is shorthand for "a Fraction whose value is that
 * of the Fraction plus that of the Fraction j". Other pseudo-code
 * expressions are interpreted similarly. 
 *
 * @see java.math.BigInteger
 *
 * @author Thomas Shaddock
 */
public class Fraction {

    /* Insert your instance variables here. */
    private BigInteger numerator;
    private BigInteger denominator;
    
    /**
     * Constructs a Fraction taking the value of its parameter.
     *
     * @param val  non-null; the value the Fraction is supposed to take
     */
    public Fraction(BigInteger val) {
        this.numerator = val;
        this.denominator = BigInteger.valueOf(1);
    }

    /**
     * Constructs a new Fraction taking the value of its parameter.
     *
     * @param val  the value the Fraction is supposed to take
     */
    public Fraction(long val) {        

        //use the long value and assign it to the class numerator, use the valueOf methods of bigInteger to convert the long datatype into BigInteger
        this.numerator = BigInteger.valueOf(val);
        this.denominator = BigInteger.valueOf(1);
    }

    /**
     * Constructs a Fraction corresponding to numerator / denominator.
     * The value is 0 if denominator is 0.
     *
     * @param numerator  non-null; value of the numerator
     * @param denominator  non-null; value of the denominator
     */
    public Fraction(BigInteger numerator, BigInteger denominator) {

        if(denominator == BigInteger.valueOf(0)){

            System.out.println("Error, your denominator parameter cannot be Zero!");
        }

        //use the compareTo method in BigInteger and compare with a BigInteger value of 0
        //-1 = less than
        //0 = eaual to
        //+1 = greater than
        int res = denominator.compareTo(BigInteger.valueOf(0)); 

        //deal with negative input fractions using the BigInteger.multiply method
        if(res < 0){

            numerator = numerator.multiply(BigInteger.valueOf(-1));
            denominator = denominator.multiply(BigInteger.valueOf(-1));
        }

        //assign the private class variables the values        
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Constructs a Fraction corresponding to numerator / denominator.
     * The value is 0 if denominator is 0.
     *
     * @param numerator  the numerator of the Fraction
     * @param denominator  the denominator of the Fraction
     */
    public Fraction(long numerator, long denominator) {
        if(denominator == 0){

            System.out.println("Error, your denominator parameter cannot be Zero!");
        }


    }

    /**
     * Returns a Fraction whose value is (this + val).
     * (Note that a/b + c/d = (a*d + b*c)/(b*d).)
     * 
     * @param val  non-null; to be added to this
     * @return this + val
     */
    public Fraction add(Fraction val) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns the sum of all elements of vals.
     *
     * @param fractions  array of Fractions to be summed up; may be or contain null
     * @return null if vals is or contains null; the sum of all elements of
     *  vals otherwise
     */
    public static Fraction sumAll(Fraction[] fractions) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns a Fraction whose value is (this - val).
     *
     * @param val  non-null; to be subtracted from this Fraction
     * @return this - val
     */
    public Fraction subtract(Fraction val) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns a Fraction whose value is (this * val).
     * (Note that a/b * c/d = (a*c)/(b*d).)
     *
     * @param val  non-null; to be multiplied to this Fraction
     * @return this * val
     */
    public Fraction multiply(Fraction val) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns a Fraction whose value is (this / val).  
     * 
     * @param val  non-null; value by which this Fraction is to be divided
     * @return this / val
     */
    public Fraction divide(Fraction val) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns a Fraction whose value is (-this).
     *
     * @return -this
     */
    public Fraction negate() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns the inverse of this Fraction, i.e., the Fraction 1 / this.
     * 
     * @return 1 / this
     */
    public Fraction invert() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns the sign of this Fraction: 1 if its value is positive,
     * 0 if it is zero, -1 if it is negative.
     *
     * @return the sign of this Fraction (1 if its value is positive,
     *  0 if it is zero, -1 if it is negative) 
     */
    public int signum() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Returns the absolute value of this Fraction, i.e.,
     * the value of the Fraction itself if it is non-negative,
     * otherwise the negated value.
     * 
     * @return the absolute value of this Fraction
     */
    public Fraction abs() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns the maximum of this Fraction and val.
     *
     * @param val  non-null; the value with which the maximum is to be computed
     * @return the maximum of this Fraction and val
     */
    public Fraction max(Fraction val) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns the minimum of this Fraction and val.
     *
     * @param val  non-null; the value with which the minimum is to be computed
     * @return the minimum of this Fraction and val
     */
    public Fraction min(Fraction val) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns this Fraction taken to the power of exponent. Here
     * exponent may also be zero or negative. Note that a^0 = 1 and
     * a^b = (1/a)^(-b) if b < 0. 
     * 
     * @param exponent  the exponent to which we want to take this
     * @return this Fraction taken to the power of exponent
     */
    public Fraction pow(int exponent) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Compares this Fraction with the specified Fraction.
     * 
     * @param val  non-null; value with which this Fraction is to be compared 
     * @return -1, 0 or 1 as this Fraction is numerically less than,
     *         equal to, or greater than val
     * @see java.math.BigInteger#compareTo(BigInteger)
     */
    public int compareTo(Fraction val) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Checks if this Fraction and val represent equal values.
     *
     * @param val  potentially null (in this case the method returns false);
     *  the value with which this Fraction is to be compared for equality
     * @return true if this Fraction and other represent the same value;
     *  false otherwise
     */
    public boolean isEqualTo(Fraction val) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Returns a normalised String representation of this Fraction.
     * For example, new Fraction(5,3) and new Fraction(-10,-6) will
     * be represented as "(5 / 3)". The String representation of
     * new Fraction(5,-10) and new Fraction(-12,24) is "(-1 / 2)".
     *
     * In case this Fraction has an integer value, just the String
     * representation of the integer value is returned. For example,
     * new Fraction(-2) has the String representation "-2"; and
     * new Fraction(0), new Fraction(0,3), and new Fraction(4,0)
     * all have the String representation "0".
     *
     * @return a normalised String representation of this Fraction
     */
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}
