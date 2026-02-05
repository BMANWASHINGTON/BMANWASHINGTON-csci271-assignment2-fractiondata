 public class TestFraction {
    public static void main (String[] args) {
        Fractions f1 = new Fractions(6, -24);
        System.out.println(f1);
        
        Fractions f2 = new Fractions(0, 8);
        System.out.println(f2);
        
        Fractions f3 = new Fractions(16);
        System.out.println(f3);
        
        Fractions t1 = new Fractions(8, -6);
        Fractions t2 = new Fractions(23, 0);
        Fractions t3 = new Fractions(-6, 0);
        Fractions t4 = new Fractions(7, 1);
        Fractions t5 = new Fractions(0, 0);
        
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        
        Fractions a1 = new Fractions(3, 5);
        Fractions a2 = new Fractions(7);
        Fractions addRes = a1.add(a2);
        System.out.println(addRes);
        
        Fractions s1 = new Fractions(5,6);
        Fractions s2 = new Fractions(1,3);
        Fractions subRes = s1.subtract(s2);
        System.out.println(subRes);
        
        Fractions m1 = new Fractions(2,3);
        Fractions m2 = new Fractions(9,4);
        Fractions multiRes = m1.multiply(m2);
        System.out.println(multiRes);
        
        Fractions d1 = new Fractions(4,5);
        Fractions d2 = new Fractions(2,3);
        Fractions divRes = d1.divide(d2);
        System.out.println(divRes);
        
        Fractions n1 = new Fractions(5,7);
        Fractions negRes = n1.negate();
        System.out.println(negRes);
        
        Fractions inf = new Fractions(1,0);
        Fractions nInf = inf.negate();
        Fractions nan = new Fractions(0,0);
        Fractions nNan = nan.negate();
        System.out.println(nInf);
        System.out.println(nNan);
        
        Fractions p1 = new Fractions(2,3);
        Fractions powPos = p1.pow(3);
        System.out.println(powPos);
        
        Fractions p2 = new Fractions(5,9);
        Fractions powZero = p2.pow(0);
        System.out.println(powZero);
        
        Fractions p3 = new Fractions(2,5);
        Fractions powNegate = p3.pow(-2);
        System.out.println(powNegate);
        
        Fractions a = new Fractions(16);
        Fractions b = new Fractions(3,5).add(new Fractions(7));
        Fractions c = new Fractions(6,7);
        Fractions result = c.multiply(a.divide(b));
        System.out.println(result);
        
    }
}

    