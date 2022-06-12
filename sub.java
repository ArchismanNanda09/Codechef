package codechef;
import java.util.*;
import java.util.Arrays;
public class sub {
	static int arr(int a[], int l, int r, int x) {
		int c=0;
		int suba[] = Arrays.copyOfRange(a, l, r);
		for(int j=0;j<suba.length;j++) {
			if(suba[j]>=x)
				c++;
		}
		return c;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		while(q-->=0) {
			int l=sc.nextInt();
			int r=sc.nextInt();
			int x=sc.nextInt();
			System.out.println(arr(a,l,r,x));
			
		}
		
		
	}

}
