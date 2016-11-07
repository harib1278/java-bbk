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
     * Constructs a Fraction taking the value of its parameter.ja
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
        this.numerator   = BigInteger.valueOf(val);
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

        //use the compareTo method in BigInteger and compare with a BigInteger value of 0
        //-1 = less than
        //0 = eaual to
        //+1 = greater than
        int res = denominator.compareTo(BigInteger.valueOf(0)); 

        //deal with negative input fractions using the BigInteger.multiply method
        if(res < 0){

            numerator = numerator.multiply(BigInteger.valueOf(-1));
            denominator = denominator.multiply(BigInteger.valueOf(-1));
        } else if(res == 0){

            //make the fraction 0 / 0 if the denominator is 0
            numerator   = BigInteger.valueOf(0);
            denominator = BigInteger.valueOf(0);
        }

        //assign the private class variables the values        
        this.numerator   = numerator;
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
            //make the fraction 0/0 if the denominator is 0
            numerator = 0;
            denominator = 0;
        } else if(denominator < 0) {
            numerator   *= -1;
            denominator *= -1;
        }

        this.numerator   = BigInteger.valueOf(numerator);
        this.denominator = BigInteger.valueOf(denominator);

    }

    /**
     * Returns a Fraction whose value is (this + val).
     * (Note that a/b + c/d = (a*d + b*c)/(b*d).)
     * 
     * @param val  non-null; to be added to this
     * @return this + val
     */
    public Fraction add(Fraction val) {
        //(this.numerator * val.denominator) + (this.denominator * val.numerator), this.denominator * val.denominator);

        // break up the calculation into logical parts of the equation
        BigInteger left  = this.numerator.multiply(val.denominator);
        BigInteger right = this.denominator.multiply(val.numerator);

        //now add
        left  = left.add(right);

        //perform the final right handside calculation
        right = this.denominator.multiply(val.denominator);

        //instansiate and return
        Fraction results = new Fraction(left, right);

        return results;
    }

    /**
     * Returns a Fraction whose value is (this - val).
     *
     * @param val  non-null; to be subtracted from this Fraction
     * @return this - val
     */
    public Fraction subtract(Fraction val) {
        //(this.numerator * val.denominator) - (this.denominator * val.numerator), this.denominator * val.denominator);

        // break up the calculation into logical parts of the equation
        BigInteger left  = this.numerator.multiply(val.denominator);
        BigInteger right = this.denominator.multiply(val.numerator);

        //now subtract
        left  = left.subtract(right);

        //perform the final right handside calculation
        right = this.denominator.multiply(val.denominator);

        //instansiate and return
        Fraction results = new Fraction(left, right);

        return results;
    }

    /**
     * Returns the sum of all elements of vals.
     *
     * @param fractions  array of Fractions to be summed up; may be or contain null
     * @return null if vals is or contains null; the sum of all elements of
     *  vals otherwise
     */
    public static Fraction sumAll(Fraction[] fractions) {

        BigInteger finalNumerator    = BigInteger.valueOf(0);
        BigInteger finalDenominator  = BigInteger.valueOf(0);

        for(Fraction i : fractions){
            finalNumerator = finalNumerator.add(i.numerator);
        }

        for(Fraction i : fractions){
            finalDenominator = finalDenominator.add(i.denominator);
        }

        Fraction results = new Fraction(finalNumerator, finalDenominator);

        return results;
    }    

    /**
     * Returns a Fraction whose value is (this * val).
     * (Note that a/b * c/d = (a*c)/(b*d).)
     *
     * @param val  non-null; to be multiplied to this Fraction
     * @return this * val
     */
    public Fraction multiply(Fraction val) {
        //(a*c)
        BigInteger left  = this.numerator.multiply(val.numerator);
        //(b*d)
        BigInteger right = this.denominator.multiply(val.denominator);

        //instansiate and return
        //(a*c)/(b*d)
        Fraction results = new Fraction(left.divide(right));

        return results;
    }

    /**
     * Returns a Fraction whose value is (this / val).  
     * 
     * @param val  non-null; value by which this Fraction is to be divided
     * @return this / val
     */
    public Fraction divide(Fraction val) {
        //same also as above except the final calculation is a multiplication
        BigInteger left  = this.numerator.multiply(val.numerator);
        BigInteger right = this.denominator.multiply(val.denominator);

        //instansiate and return
        Fraction results = new Fraction(left.multiply(right));

        return results;
    }

    /**
     * Returns a Fraction whose value is (-this).
     *
     * @return -this
     */
    public Fraction negate() {

        BigInteger zero = BigInteger.valueOf(0);
        BigInteger n = zero.subtract(this.numerator);
        BigInteger d = zero.subtract(this.denominator);   

        //instansiate and return
        Fraction results = new Fraction(n, d);

        return results;
    }

    /**
     * Returns the inverse of this Fraction, i.e., the Fraction 1 / this.
     * 
     * @return 1 / this
     */
    public Fraction invert() {
        
        // switch the numerator and  denominator arround
        BigInteger n = this.denominator;
        BigInteger d = this.numerator;

        //instansiate and return
        Fraction results = new Fraction(n, d);

        return results;
    }

    /**
     * Returns the sign of this Fraction: 1 if its value is positive,
     * 0 if it is zero, -1 if it is negative.
     *
     * @return the sign of this Fraction (1 if its value is positive,
     *  0 if it is zero, -1 if it is negative) 
     */
    public int signum() {

        //if denominator or is less than 0 return -1, if both are then fraction is positive
        BigInteger n = this.numerator;
        BigInteger d = this.denominator;
        int res  = n.compareTo(BigInteger.valueOf(0));
        int res2 = d.compareTo(BigInteger.valueOf(0));

        if(res == -1 && res2 == -1){

            return 1;
        } else if (res < 0 && res2 > 0) {

            return 0;    
        } else if (res > 0 && res2 < 0) {

            return 0;    
        } else{
            //else both n and d are positive
            return 1;
        }
    }

    /**
     * Returns the absolute value of this Fraction, i.e.,
     * the value of the Fraction itself if it is non-negative,
     * otherwise the negated value.
     * 
     * @return the absolute value of this Fraction
     */
    public Fraction abs() {

        BigInteger n = this.numerator.abs();
        BigInteger d = this.denominator.abs();

        Fraction results = new Fraction(n, d);

        return results;
    }

    /**
     * Returns the maximum of this Fraction and val.
     *
     * @param val  non-null; the value with which the maximum is to be computed
     * @return the maximum of this Fraction and val
     */
    public Fraction max(Fraction val) {

        BigInteger n = BigInteger.valueOf(0);
        BigInteger d = BigInteger.valueOf(0);
        //intitalise the greatest common denominatior
        BigInteger gcdom = BigInteger.valueOf(0);

        gcdom = this.numerator.gcd(this.denominator);


        n = this.numerator.multiply(gcdom);
        d = this.denominator.multiply(gcdom);

        Fraction results = new Fraction(n, d);

        return results;
    }

    /**
     * Returns the minimum of this Fraction and val.
     *
     * @param val  non-null; the value with which the minimum is to be computed
     * @return the minimum of this Fraction and val
     */
    public Fraction min(Fraction val) {        

        BigInteger n = BigInteger.valueOf(0);
        BigInteger d = BigInteger.valueOf(0);
        //intitalise the greatest common denominatior
        BigInteger gcdom = BigInteger.valueOf(0);
        //initialise lowest common multiple
        BigInteger lcm = BigInteger.valueOf(0);

        gcdom = this.numerator.gcd(this.denominator);
        
        //use eulclidean algo to determine lowest common multiple
        //lcm = a / gcd * b
        lcm = n.divide(gcdom.multiply(d));


        n = this.numerator.divide(lcm);
        d = this.denominator.divide(lcm);

        Fraction results = new Fraction(n, d);

        return results;

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
        BigInteger n = this.numerator;
        BigInteger d = this.denominator;

        n = n.pow(exponent);
        d = d.pow(exponent);

        Fraction results = new Fraction(n, d);

        return results;
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
        BigInteger first = this.numerator.multiply(val.denominator);
        BigInteger second = val.numerator.multiply(this.denominator);

        int res = first.compareTo(second);

        if(res > 0) {

            return 1;

        } else if (res < 0) {

            return -1;

        } else {
            //res == 0
            return 0;
        }
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

        //use the method created above
        if(this.compareTo(val) == 0){
            return true;
        }

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

        //initalise method variables
        String results = "";
        BigInteger resultNumerator   = BigInteger.valueOf(0);
        BigInteger resultDenominator = BigInteger.valueOf(0);
        BigInteger gcdom = BigInteger.valueOf(0);

        //compare the two values to 0
        int resNumerator   = this.numerator.compareTo(BigInteger.valueOf(0));
        int resDenominator = this.denominator.compareTo(BigInteger.valueOf(0));

        //if fraction denominator or numerator are 0 then return 0
        if(resNumerator == 0 || resDenominator == 0){
            results = "0";
        } else {
            //calculate the normalised fraction
            if (resDenominator < 0) {

                resultNumerator = this.numerator.multiply(BigInteger.valueOf(-1));
                resultDenominator = this.denominator.multiply(BigInteger.valueOf(-1));

            } else {
                //get greatest common denominator using gcd method
                gcdom = this.numerator.gcd(this.denominator);

                resultNumerator = this.numerator.divide(gcdom);
                resultDenominator = this.denominator.divide(gcdom);
            }
            results = resultNumerator + " / " + resultDenominator;
        }
        
        return results;
    }
}
