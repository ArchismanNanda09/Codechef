package codechef;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class permute
{
	static int[] sort(int p[]){
        for(int i=0;i<p.length;i++){
            for(int j=i;j<p.length-i;j++){
                if(p[j]>p[j+1]){
                    int t = p[j];
                    p[j]=p[j+1];
                    p[j+1]=t;
                }
            }
        }
        return p;
    }
	static int[] delete(int a[], int index){
        if (a==null || index < 0
           || index >= a.length) {

           return a;
            
       }
       int arr[] = new int[a.length-1];
       for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
               continue;
           }
            arr[k++] = a[i];
       }
        return arr;
   }
    static int[] permutation(int p[]){
        for(int i=0;i<p.length;i++){
            sort(p);
            if(p[i]==p[i+1]) {
            	delete(p,i);
            	
            }
            
            
        }
        return p;
    }
    static int[] divide(int[]p) {
    	int arr[] = new int[p.length];
    	
    	for(int i=0;i<p.length;i++) {
    		permutation(p);
    		if(Math.abs(p[i+1]-p[i])%i==0) {
    			arr[i]=p[i];
    		}
    	}
    	return arr;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
	}
}
