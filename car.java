package codechef;
import java.util.*;
public class car {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int p = sc.nextInt();
			int m = sc.nextInt();
			int v = sc.nextInt();
			int dist = v*(m-(p-1));
			System.out.println(dist);
		}
	}

}
