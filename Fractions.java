/*******************************************************************************
 Project 2: Fraction Data Types
 
 Author: Bryce Washington
 Date: February 3, 2026
 Course: CSCI 271 001
 Term: Spring 2026
 
 ******************************************************************************/
 
 /******************************************************************************
  I declare and confirm the following:
  - I have not discussed this program code with anyone other than my instructor
  or the teaching assistants assigned to this course.
  - I have not used programming code obtained from someone else, or any
  authorised sources, including the Internet, either modified or unmodified.
  - If any source code or documentation used in my program was obtained from
  other sources, like a textbook or course notes, I have clearly indicated that
  with a proper citation in the comments of my program.
  - I have notdesigned this program in such a way as todefeat or interfere with
  the normal operation of the supplied grading code.
  
  <Bryce Washington>
  <W30668619>
  *****************************************************************************/

/******************************************************************************************************************
Description: This function creates a new fraction that is reduced & normalized so that the denominator is
             always positive. The object represents the rational number a/b.

Parameters: a - numerator, b - denominator

Pre-conditions: N/A

Post-conditions: The fraction is stored in reduced form. 
                 If b == 0, the fraction represents Infinity, -Infinity, or NaN.
                 If a == 0 and b != 0, the fraction becomes 0/1.

Returns: A new Fraction object

Called by: main(), add(), subtract(), multiply(), divide(), negate(), pow()

Calls: gcd()

******************************************************************************************************************/  
public class Fractions {
    private long num; // numerator
    private long denom; //denominator
    
    // Task 1: Created reduced, standard form fraction
    public Fractions(long a, long b) {
        if (b == 0) {
	    // Infinity & NaN
            this.num = a; // > 0 -> Infinity, -> -Infinity, 0 -> NaN
            this.denom = 0;
        }
        else {
	    // Normalize: denominator >= 0
            if (b < 0) {
                a = -a;
                b = -b;
            }
            
            if (a == 0) {
            // 0 in normalized form is 0/1
                this.num = 0;
                this.denom = 1;
            }
            else {
                long g = gcd(a, b);
                this.num = a / g;
                this.denom = b / g;
            }
        }
    }
    
    // Task 1: constructor a/1
    public Fractions (long a) {
        this(a, 1);
    }
    
    // GCD algorithm
    private static long gcd(long a, long b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        
        if (a == 0) a = 1;
        return a;
    }
    
    private boolean isNan() {
        return denom == 0 && num == 0;
    }
    
    private boolean isInfinity() {
        return denom == 0 && num != 0;
    }
    
    // Task 2: ToString() function
    @Override
    public String toString() {
        if (denom == 0) {
            if (num > 0) { // Fraction is infinity 
                return "Infinity";
            }
            else if (num < 0) { // Fraction is -Infinity
                return "-Infinity";
            }
            else { // Returns "NaN'
                return "NaN";
            }
        }
        if (denom == 1) {
            return Long.toString(num);
        }
        return num + "/" + denom;
    }
    
    // Task 3: Different mathematical functions
    public Fractions divide(Fractions f) { // (a/b) (c/d) = (a*d) / (b*c)
        return new Fractions(this.num * f.denom, this.denom * f.num);
    }
    
    public Fractions multiply(Fractions f) { // (a*c) / (b*d)
        return new Fractions(this.num * f.num, this.denom * f.denom);
    }
    
    public Fractions subtract(Fractions f) { // (a*d - c*b) / (b*d)
        long n = this.num * f.denom - f.num * this.denom;
        long d = this.denom * f.denom;
        return new Fractions(n, d);
    }
    
    public Fractions add(Fractions f) { // (a*d + c*b) / (b*d)
        long n = this.num * f.denom + f.num * this.denom;
        long d = this.denom * f.denom;
        return new Fractions(n, d);
    }
    
    public Fractions negate() { // negate() function
        return new Fractions(-this.num, this.denom);
    }
    
    public Fractions pow(int n) { // pow(n) where n = 0 or is a negative
        if (isNan()) {
            return this; // NaN^n is NaN
        }
        
        if (n == 0) {
            return new Fractions(1, 1); // Any non-NaN fraction^0 = 1
        }
        
        boolean negative = n < 0;
        long exp = Math.abs((long) n);
        
        long nNum = this.num;
        long nDenom = this.denom;
        
        long numPow = 1;
        long denomPow = 1;
        
        // Repeated multiplication
        for (long i = 0; i < exp; i++) {
            numPow *= nNum;
            denomPow *= nDenom;
        }
        
        if (negative) {
            return new Fractions(denomPow, numPow);
        }
        else {
            return new Fractions(numPow, denomPow);
        }
    }
}

