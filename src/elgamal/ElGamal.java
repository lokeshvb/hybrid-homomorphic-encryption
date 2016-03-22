
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elgamal;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class ElGamal{
		
	public static void main(String[] args) {
           
            Scanner s=new Scanner(System.in);
	keygeneration k=new keygeneration();
        k.generatekeys();
         
        System.out.println("encrytpion started");
        Encryption E=new Encryption();
        long encstart=System.currentTimeMillis();
        E.Encrypt(k.getp(),k.getg(),k.getb(),k.getSecretkey());
        long encend=System.currentTimeMillis();
        System.out.println("encryption done");
       decryption d=new decryption();
       
     //  System.out.println("enter the secret key to decrypt the file::");
      // int a=s.nextInt();
        //BigInteger b = BigInteger.valueOf(a);
        long start=System.currentTimeMillis();
        d.decrypt(k.getp(),k.getSecretkey(), null);
        long end=System.currentTimeMillis();
        long diff=end-start;
        long diff2=encend-encstart;
        System.out.println(diff2+"  milli seconds for encryption\n"+diff+"  milli seconds fordecryption");
        
	
			
        }
        
}
                   
	