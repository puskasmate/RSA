package Main;

import java.math.BigInteger;
import java.util.ArrayList;

public class FME {

    public static BigInteger Fme (BigInteger a, BigInteger b, BigInteger c) {


        ArrayList<BigInteger> mods = new ArrayList<>();
        ArrayList<BigInteger> pwT = pwT(b);
        BigInteger final_mod;



        for(int i=0; i<pwT.size(); i++) {
            mods.add(a.modPow(BigInteger.valueOf((long)Math.pow(2, pwT.get(i).longValue())), c));
        }

    BigInteger temp  = mods.stream().reduce(BigInteger.valueOf(1), (k, l) -> k .multiply(l));
        final_mod = temp.mod(c);

        return final_mod;

    }

    public static ArrayList<BigInteger> pwT (BigInteger n) {

        ArrayList<BigInteger> temp = new ArrayList<>();
        ArrayList<BigInteger> powers = new ArrayList<>();

        while (!n.equals(BigInteger.ZERO)) {
            temp.add(n.remainder(BigInteger.TWO));
            n = n.divide(BigInteger.TWO);
        }

        for(int i = 0; i < temp.size(); i++)
            if(temp.get(i).equals(BigInteger.ONE)) {
                powers.add(BigInteger.valueOf(i));
            }
        return powers;
    }
}