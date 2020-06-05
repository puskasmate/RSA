package Main;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RSA {

    public static BigInteger n;
    public static BigInteger e= BigInteger.valueOf(3);
    public static BigInteger d;

    private static MR mr = new MR();




    public void generateKeys(){
        Random random = new Random();
        BigInteger p = BigInteger.probablePrime(32, random);
        BigInteger q = BigInteger.probablePrime(32, random);
        BigInteger n;
        BigInteger f;
        int e;
        BigInteger d;
        BigInteger x;

        while(p.equals(q)){
            p=BigInteger.probablePrime(32, random);
        }
        n = p.multiply(q);
        f = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));


        e = generateE(BigInteger.valueOf(random.nextInt()), f).intValue();
        while (e<0)
            e = generateE(BigInteger.valueOf(random.nextInt()), f).intValue();

        x = EEA.EEA(BigInteger.valueOf(e),f);

        if(x.signum()==-1){
            d = x.add(f);
        }else{
            d = x;
        }

        this.n = n;
        this.d = d;
        this.e = BigInteger.valueOf(e);
        System.out.println("Publikus kulcs: ("+n+", "+e+")");
        System.out.println("Privát kulcs: "+d);

    }

    public static boolean isRelativePrime(BigInteger a, BigInteger b){
        return EEA.EA(a, b).equals(BigInteger.ONE);
    }

    public static BigInteger Encrypt (BigInteger m) {
        Scanner scanner = new Scanner(System.in);

        while (m.compareTo(n) > 0){
            System.out.println("Próbálkozz egy kisebb számmal!");
            m = scanner.nextBigInteger();
        }

        return FME.Fme(m, e, n);

    }

    public static BigInteger Decrypt (BigInteger c) {

        return FME.Fme(c, d, n);

    }

    public BigInteger generateE (BigInteger e, BigInteger f) {
        Random random = new Random();
        while (!isRelativePrime(e,f)){

            e = BigInteger.valueOf(random.nextInt());

        }
        return e;
    }

}