import java.util.Scanner;
import java.lang.StringBuffer;
import java.lang.String;
import java.lang.Math;
public class test4
{
 private static Scanner scan=new Scanner(System.in);
 public static void main(String[]args)
 {
  StringBuffer buffer = new StringBuffer("");
  long start = System.nanoTime();
  int i;
   for(i=0;i<1000;i++)
   buffer.append(i+",");
   for(i=0;i<10000;i++)
   buffer.append(i+",");
   for(i=0;i<20000;i++)
   buffer.append(i+",");
   for(i=0;i<40000;i++)
   buffer.append(i+",");
   for(i=0;i<60000;i++)
   buffer.append(i+",");   
   System.out.println(buffer);
   long duree = System.nanoTime() - start;
   System.out.println(duree+" nano seconde");
 } 
}
 


