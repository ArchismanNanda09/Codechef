package codechef;
import java.util.*;
import java.lang.*;
import java.io.*;
public class rectangle
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)	
	    {
	       int n=sc.nextInt();
	       R[] a=new R[n];
	       for(int j=0;j<n;j++)
	       {
	           a[j]=new R();
	           a[j].vx=sc.nextInt();
	           a[j].vy=sc.nextInt();
	           a[j].dx=sc.nextInt();
	           a[j].dy=sc.nextInt();
	           a[j].dir=sc.nextInt();
	       }
	       for(int k=0;k<n;k++)
	       {
	           String s1=sc.next();
	           char c=s1.charAt(1);
	           Writer writer=new PrintWriter(System.out);
	           if(c=='E')
	           {
	               a[k].dir=(a[k].dir + 2) % 4;
	               System.out.println((k+1)+" "+(k+1));
	           }
	           else
	           {
	               a[k].dir=(a[k].dir+1)%4;
	               System.out.println((k+1)+" "+(a[k].dir)+" "+(k+1));
	   	       }
	           writer.flush();
	       }
	   }
	}
}
class R
{
    int vx,vy,dx,dy,dir;
	
}

