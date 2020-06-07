package Main;

import java.math.BigInteger;



public class MR {



        private  static BigInteger d;
        private  static int r=0;
        private static int count = 0;


        private FME fme = new FME();

        public static boolean isPrime(BigInteger n){
            getRandD(n);

            if((FME.Fme(BigInteger.TWO,d,n).equals(BigInteger.valueOf(1)))&&(FME.Fme(BigInteger.TEN,d,n).equals(BigInteger.valueOf(1)))&&(FME.Fme(BigInteger.valueOf(5),d,n).equals(BigInteger.valueOf(1)))){
                count++;
            }

            for(int i = 0; i< r; i++){
                if(FME.Fme(BigInteger.TWO, d.multiply(BigInteger.valueOf((long) Math.pow(2,i))),n).equals(BigInteger.valueOf(-1))){
                    count++;
                }
                if(FME.Fme(BigInteger.TEN, (d.multiply(BigInteger.valueOf((long) Math.pow(2,i)))),n).equals(BigInteger.valueOf(-1))){
                    count++;
                }
                if(FME.Fme(BigInteger.valueOf(5), (d.multiply(BigInteger.valueOf((long) Math.pow(2,i)))),n).equals(BigInteger.valueOf(-1))){
                    count++;
                }
            }

            return count >= 3;
        }
        public static void getRandD(BigInteger n){

            if(!((n.remainder(BigInteger.TWO)).equals(BigInteger.ZERO))){
                n = n.subtract(BigInteger.ONE);
            }

            while (((n.remainder(BigInteger.TWO)).equals(BigInteger.ZERO))){
                n = n.divide(BigInteger.TWO);
                r++;
            }
            d = n;
        }

    }








