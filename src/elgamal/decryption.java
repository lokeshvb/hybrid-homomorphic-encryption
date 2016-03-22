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
import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;
public class decryption {
    String s1="",s2="";
    FileWriter f1,f2,f3;
    
            // create file output stream
            
    public void decrypt(BigInteger p,BigInteger secretkey,String file)
    {
        try{
            f2=new FileWriter("D:\\output of project\\second_decryption.txt");
            f3=new FileWriter("D:\\output of project\\decrypted.txt");
            f1=new FileWriter("D:\\output of project\\first_decrytpion.txt");
        String substring="";
        int j=0,sk=secretkey.intValue();
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\output of project\\Encryption.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      // process the line.
        int i=0;j=0;
        for(i=0;i<48;i=i+3)
        {
            if(j<8){
             substring=line.substring(i,i+3);
            int a=Integer.parseInt(substring);
            
            int bit=(a%sk)%2;
            s1=s1+Integer.toString(bit);
            //System.out.print(bit);
            j++;
            }
            
            else
            {
                substring=line.substring(i,i+3);
            int a=Integer.parseInt(substring);
            
            int bit=(a%sk)%2;
            //System.out.print(bit);
           s2=s2+Integer.toString(bit);
            j++;}
            //System.out.print(substring);
            if(j==8);
        //        System.out.print("\t\t");
        }
        //System.out.print("\n");
       // System.out.println(s1+"    "+s2);
        BigInteger c1,c2;
        f1.write("input is ="+line+" binary ="+s1+"   "+s2+"\n");
        f1.flush();
        int a1=binaryToInteger(s1);
        int a2=binaryToInteger(s2);
        
       // System.out.println("c1 is "+a1+"  c2 is "+a2);
        c1=BigInteger.valueOf(binaryToInteger(s1));
        c2=BigInteger.valueOf(binaryToInteger(s2));
        f2.write("binary   "+s1+"  "+s2+"\tc1="+c1+"\tc2="+c2+"\n");
        f2.flush();
         BigInteger temp = c1.modPow(secretkey,p);
            temp = temp.modInverse(p);
            BigInteger recover = temp.multiply(c2);
            recover = recover.mod(p);
            char ch=(char)recover.intValue();
           // System.out.print(ch);
            f3.write(ch);
            f3.flush();
           // String c=Integer.toString(recover.intValue());
            
            
       
        
        
        
        s1="";
        s2="";
        //System.out.println("c1 is "+"  c2 is "+c2);
       
    }
}
        catch(Exception e){}
   
       
        }
        catch(Exception e){System.out.println("exception at decrytion file");}
        }
        
        
    public int binaryToInteger(String binary) {
    char[] numbers = binary.toCharArray();
    int result = 0;
    for(int i=numbers.length - 1; i>=0; i--)
        if(numbers[i]=='1')
            result += Math.pow(2, (numbers.length-i - 1));
    return result;
}
}
