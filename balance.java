package codechef;
import java.util.*;
public class balance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			char c[]= new char[n];
			for(int i=0;i<n;i++) {
				c[i]=sc.next().charAt(0);
			}
			int c1=0;
			int c2=0;
			for(int i=0;i<n;i++) {
				if(c[i]=='0')
					c1++;
				if(c[i]=='1')
					c2++;
				int val = Math.abs(c2-c1);
				int c3=0;
				while(c[i]=='?') {
					c3++;
					if(c3==1) {
						if(c2>c1) {
							c[i]='0';
							c1++;
						}
						else if(c2<=c1) {
							c[i]='1';
							c2++;
						}
						
						
					}
					else {
						if(c2>c1) {							
							c1++;
							while(Math.abs(c2-c1)<val) {
								c[i]='0';
							}
							
						
						}
						else if(c2<c1) {
							c2++;
							while(Math.abs(c2-c1)<val) {
								c[i]='1';
							}
						}
						else if(c2==c1) {
							
						}
					}
				}
				
				
			}
			
		}

	}

}
