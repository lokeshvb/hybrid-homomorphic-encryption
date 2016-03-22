/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elgamal;

/**
 *
 * @author kani
 */
import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import static java.lang.Math.*;
public class keygeneration {
     private BigInteger p;
     private BigInteger g;
     private BigInteger SECRETKEY;
     private BigInteger b;
     private int pval[]={151,157,163,167,179,};
     private int xval[]={45,47,49,51,53,57};
    public void generatekeys()
    {
         Scanner stdin = new Scanner(System.in);
    
		Random r = new Random();
                double ran=  random();
        int ran2=(int) ((ran*100)%5);
        
       // System.out.println(ran+"      "+ran2);
       //p=pval[ran2];
       ran2=1;
//		System.out.println("Enter the approximate value of the prime number for your El Gamal key.");
		p = BigInteger.valueOf(pval[ran2]);
		
		// Calculate a generator.
		g = getGenerator(p, r);
		
		// We found a generator, so let's do the rest of t.
		if (g != null) {
		
			// Pick a secret a.
                   // System.out.println("enter secret key");
                   // int sk= stdin.nextInt();
                       SECRETKEY = BigInteger.valueOf(xval[ran2]);
			
			// Calculate the corresponding public b.
			b = g.modPow(SECRETKEY, p);
		
			// Print out our public keys.
			System.out.println("public keys:: p = "+p+" g = "+g+" b = "+b +"\nsecret key ::"+SECRETKEY);
                        
                }
                
             else
			System.out.println("Sorry, a generator for your prime couldn't be found.");
    }
    
    public static BigInteger getNextPrime(String ans) {
		
		BigInteger one = new BigInteger("1");
		BigInteger test = new BigInteger(ans);
		while (!test.isProbablePrime(99))
			test = test.add(one);
		return test;		
	}
	
	
	
	public static BigInteger getGenerator(BigInteger p, Random r) {

		int numtries = 0;
		while (numtries < 1000){
                    BigInteger rand = new BigInteger(p.bitCount()-1,r);
    		BigInteger exp = BigInteger.ONE;
    		BigInteger next = rand.mod(p);
                while (!next.equals(BigInteger.ONE)) {
      			next = (next.multiply(rand)).mod(p);
      			exp = exp.add(BigInteger.ONE);
    		}

    		if (exp.equals(p.subtract(BigInteger.ONE)))
      			return rand;
      	}
        return null;
      	
        }
        public BigInteger getp()
        { return p;}
        public BigInteger getg()
        { return g;}
        public BigInteger getb()
        { return b;}
        public BigInteger getSecretkey()
        { return SECRETKEY;}
        
}