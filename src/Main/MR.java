package Main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MR {

        public static boolean isPrime(BigInteger p,BigInteger a){
            if(p.intValue()>3 && (a.intValue()>=2 && a.compareTo(p)==-1)){

                if(p.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                    return false;
                }

                int aMax = p.subtract(BigInteger.ONE).intValue();
                int aMin = a.intValue()+1;
                List<BigInteger> aValues = new ArrayList<>();
                aValues.add(a);
                for(int i = 0; i<2;i++){
                    aValues.add(generateRandomBigInteger(aMin,aMax));
                }

                BigInteger d = p.subtract(BigInteger.ONE);
                int s =0;
                while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                    d = d.divide(BigInteger.TWO);
                    s++;
                }

                BigInteger t;
                int checkIfPrimeCount = 0;
                int checkForAllA = 0;
                for (BigInteger aValue : aValues) {
                    t = FME.Fme(aValue,d, p);
                    if(t.equals(BigInteger.ONE)){
                        checkIfPrimeCount++;
                    }
                    for (int i = 0; i < s; i++) {
                        t = FME.Fme(aValue,BigInteger.valueOf(2).pow(i).multiply(d), p);
                        if (t.equals(BigInteger.valueOf(-1))) {
                            checkIfPrimeCount++;
                        }
                    }
                    if(checkIfPrimeCount==s){
                        checkForAllA++;
                    }
                }
                return checkForAllA == aValues.size();
            }
            throw new IllegalArgumentException("Wrong arguments: p must be > 3 and a must be >=2 and <p");

        }
        public static BigInteger generateRandomBigInteger(int min, int max){
            Random random = new Random();

                return BigInteger.valueOf(random.nextInt((max - min) + 1)+ min);


        }
    }








