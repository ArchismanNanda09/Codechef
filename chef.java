package codechef;
import java.util.*;
public class chef {
	static String buy(double s, double a[], double c) {
		double amount = s+(s*(c/100));
		for(int i=0;i<a.length;i++) {
			if(amount>a[a.length-1]) {
				return "No";
			}
		}
		return "Yes";
		
	}
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		double s = sc.nextDouble();
		double c = sc.nextDouble();
		double a[] = new double[(int)s];
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextDouble();
		}
		System.out.println(buy(s, a, c));
	}

}
