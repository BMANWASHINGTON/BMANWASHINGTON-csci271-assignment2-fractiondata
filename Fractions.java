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
  
public class Fractions {
    private long num;
    private long denom;
    
    public Fractions(long a, long b) {
        if (b == 0) {
            this.num = a;
            this.denom = 0;
        }
        else {
            if (b < 0) {
                a = -a;
                b = -b;
            }
            
            if (a == 0) {
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
    
    public Fractions (long a) {
        this(a, 1);
    }
    
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
    
    @Override
    public String toString() {
        if (denom == 0) {
            if (num > 0) {
                return "Infinity";
            }
            else if (num < 0) {
                return "-Infinity";
            }
            else {
                return "NaN";
            }
        }
        if (denom == 1) {
            return Long.toString(num);
        }
        return num + "/" + denom;
    }
    
    public Fractions divide(Fractions f) {
        return new Fractions(this.num * f.denom, this.denom * f.num);
    }
    
    public Fractions multiply(Fractions f) {
        return new Fractions(this.num * f.num, this.denom * f.denom);
    }
    
    public Fractions subtract(Fractions f) {
        long n = this.num * f.denom - f.num * this.denom;
        long d = this.denom * f.denom;
        return new Fractions(n, d);
    }
    
    public Fractions add(Fractions f) {
        long n = this.num * f.denom + f.num * this.denom;
        long d = this.denom * f.denom;
        return new Fractions(n, d);
    }
    
    public Fractions negate() {
        return new Fractions(-this.num, this.denom);
    }
    
    public Fractions pow(int n) {
        if (isNan()) {
            return this;
        }
        
        if (n == 0) {
            return new Fractions(1, 1);
        }
        
        boolean negative = n < 0;
        long exp = Math.abs((long) n);
        
        long nNum = this.num;
        long nDenom = this.denom;
        
        long numPow = 1;
        long denomPow = 1;
        
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

