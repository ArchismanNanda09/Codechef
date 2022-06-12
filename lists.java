package codechef;
import java.util.*;
import java.util.Arrays;
public class lists {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int N = sc.nextInt();
			int a[] = new int[N];
			for(int i=0;i<N;i++) {
				a[i]=sc.nextInt();
				
			}
			Arrays.sort(a);
			int max=1;
			int min=1;
			for(int i=1;i<N;i++)
			{
				if(a[i]==a[i-1]) {
					min++;
					max = Math.max(max, min);
				}
				else {
					min=1;
				}
			}
			if(N==max) {
				System.out.println(0);
				continue;
			}
			if(max==1) {
				System.out.println(-1);
				continue;
			}
			System.out.println((N-max)+1);
			
		}
	}
			
		
	}


