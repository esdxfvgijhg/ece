import java.util.Scanner;
public class permuter
{
 public int a,b;
 public permuter(int a,int b)
 {
  this.a=a;
  this.b=b;
 }
 public void permut()
 {
  int x=a;
      a=b;
      b=x;
 }
 public void affiche()
 {
  System.out.println("x= "+a+"\ny= "+b);
 }
 public static Scanner scan=new Scanner(System.in);
 public static void main (String[] args)
 {   
  permuter p=new permuter(scan.nextInt(),scan.nextInt());
  p.affiche();
  p.permut();
  p.affiche();
 }
}
