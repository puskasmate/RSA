package Main;

import java.math.BigInteger;
import java.util.ArrayList;

public class EEA {
    public static BigInteger EA(BigInteger a, BigInteger b){
        BigInteger r;
        while(!b.equals(BigInteger.ZERO)){
            r = a.mod(b);
            a = b;
            b = r;
        }
        return a;
    }
    public static BigInteger EEA(BigInteger a, BigInteger b) {
        BigInteger x0 = BigInteger.ONE;
        BigInteger x1 = BigInteger.ZERO;
        int k = 0;
        BigInteger x;
        BigInteger r;
        BigInteger q;

        while (!b.equals(BigInteger.ZERO)) {
            r = a.mod(b);
            q = a.divide(b);
            a = b;
            b = r;
            x = x1;
            x1 = x1.multiply(q).add(x0);
            x0 = x;
            k++;
        }
        x = BigInteger.valueOf(-1).pow(k).multiply(x0);
        return x;
    }
}




