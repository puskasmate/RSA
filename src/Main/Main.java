package Main;




import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        RSA rsa = new RSA();
        rsa.generateKeys();
        Scanner inNum = new Scanner(System.in);
        Scanner inLine = new Scanner(System.in);

        System.out.println("Add meg az üzenetet!");
        BigInteger msg = inNum.nextBigInteger();

        System.out.println("Add meg, hogy titkosítani (e), vagy törni (d) szeretnéd!");
        String s = inLine.nextLine();

        if(s.charAt(0)=='e') {
            BigInteger sec = RSA.Encrypt(msg);
            System.out.println("A titkosított üzenet: "+sec);
        }

        if(s.charAt(0)=='d') {
            BigInteger br = RSA.Decrypt(msg);
            System.out.println("A tört üzenet: "+br);
        }

    }

}





