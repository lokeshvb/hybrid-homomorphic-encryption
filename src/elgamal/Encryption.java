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
import static java.lang.Math.random;
import java.util.*;
import java.math.BigInteger;
public class Encryption {
    FileInputStream fin;
    FileOutputStream fout = null;
    FileWriter f1,f2,f3;
    String s1,s2;
    private int sk;
       double counter=0;
       
 
       
		
    
    public void Encrypt(BigInteger p,BigInteger g, BigInteger b,BigInteger a)
    {
        sk=a.intValue();
         int alert=0;
        try{
            // create file output stream
            f3=new FileWriter("D:\\output of project\\second_encryption.txt");
            f2=new FileWriter("D:\\output of project\\Encryption.txt");
            f1=new FileWriter("D:\\output of project\\first_encrytpion.txt");
         //fout = new FileOutputStream("D:\\output of project\\encrypted.txt");
           
         
        Scanner stdin = new Scanner(System.in);
        Random r = new Random();
        
        BigInteger k = new BigInteger(p.bitCount()-1, r);
        fin = new FileInputStream("D:\\output of project\\input.txt");
              
        int i=0;
        while((i=fin.read())!=-1){
          // System.out.println("ascii of char is "+ i);
           BigInteger c1 = g.modPow(k, p);
         BigInteger c2 = b.modPow(k, p);
          BigInteger m = BigInteger.valueOf(i);
           c2 = c2.multiply(m);
           c2 = c2.mod(p);
          char ch=(char)i;
           int intc1=c1.intValue();
           int intc2=c2.intValue();
           f1.write("character =" +ch+"\tits ASCII IS= "+i+"\tc1 value is =\t"+intc1+"\tc2 value is =\t"+intc2+"\n" );
           f1.flush();
           gentryencrytion(intc1, intc2);
           
           if( intc1 >=100 ||intc2>=100)
           { alert=1;
        //   System.out.println("value goes greather than 100");
           }
           String s1=Integer.toString(intc1);
           String s2=Integer.toString(intc2);
           byte b1[]=s1.getBytes();
           byte b2[]=s2.getBytes();
        //  fout.write(b1);
        //    fout.write(b2);
         // fout.
       //System.out.println("c1 is "+c1+"  c2 is "+c2);
           BigInteger temp = c1.modPow(a,p);
            temp = temp.modInverse(p);
            BigInteger recover = temp.multiply(c2);
            recover = recover.mod(p);
      //System.out.println("orginal value is "+recover);
     counter++;
                      
    }
        //System.out.println("count value is  " +counter+ "alert is "+alert);
        
        }
        catch(Exception e){
        System.out.println(e+"\n  create output of project folder in d drive and add input.txt file in it");}
    
}
    public void gentryencrytion(int a, int b)
    {
        s1=Integer.toBinaryString(a);
        s2=Integer.toBinaryString(b);
        switch(s1.length())
        {
            case 1:
                s1="0000000"+s1;
                break;
            case 2:
                s1="000000"+s1;
                break; 
            case 3:
                s1="00000"+s1;
                break;
            case 4:
                s1="0000"+s1;
                break; 
            case 5:
                s1="000"+s1;
                break;
            case 6:
                s1="00"+s1;
                break;
            case 7:
                s1="0"+s1;
                break; 
        }
        switch(s2.length())
        {
            case 1:
                s2="0000000"+s2;
                break;
            case 2:
                s2="000000"+s2;
                break; 
            case 3:
                s2="00000"+s2;
                break;
            case 4:
                s2="0000"+s2;
                break; 
            case 5:
                s2="000"+s2;
                break;
            case 6:
                s2="00"+s2;
                break;
            case 7:
                s2="0"+s2;
                break; 
        }
       // f1=new FileWriter("D:\\output of project\\first_level_encrytpion.txt");
       
        int gentrypubkey[]=new int[4];int r1=5,r2=3,q1=9,q2=11;
        gentrypubkey[0]=(sk*q1)+2*r1;
        gentrypubkey[1]=(sk*q1)+2*r2;
        gentrypubkey[2]=(sk*q2)+2*r1;
        gentrypubkey[3]=(sk*q2)+2*r2;
        
        String s3=s1+s2;
        char arr[]=s3.toCharArray();
        String s4=""; int genc1;
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='1')
            {
                double ran=  random();
        int ran2=(int) ((ran*100)%4);
       genc1= gentrypubkey[ran2]+1+(2*r1);
       s4=s4+Integer.toString(genc1);
            }
            else
            {
                double ran=  random();
        int ran2=(int) ((ran*100)%4);
       genc1= gentrypubkey[ran2]+0+(2*r1);
       s4=s4+Integer.toString(genc1);
            }
            
        }
         try{ 
             f3.write("c1="+a+"\tc2="+b+"\tbinary c1 "+s1+"\tbinary c2  "+s2+"\n");
           f3.flush();
           
         } catch(Exception e){}
         try{ f2.write(s4+"\n");
           f2.flush();} catch(Exception e){}
        
        
        
    }
}
