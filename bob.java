package codechef;
import java.util.*;
public class bob {
	static ArrayList<Integer>classes(int[]n, ArrayList<ArrayList<Integer>>q, ArrayList<Integer>clas) {
		
		for(int k=1;k<=n.length;k++) {
		for(int i=1;i<=q.size();i++) {
			for(int j=1;j<=q.get(i).size();j++) {
				if(q.get(i).get(1)==1) {
					
					if(j!=1) {
						clas.set(j-q.get(i).get(2), n[j-q.get(i).get(2)] );
						j=j-q.get(i).get(2);
					}
				}
				else if(q.get(i).get(1)==2) {
					if(j!=n.length-1) {
						clas.add(j+q.get(i).get(2), n[j+q.get(i).get(2)]) ;
						j=j+q.get(i).get(2);
					}
					else if(q.get(i).get(1)==3) {
						 clas.set(j+1,n[q.get(i).get(2)] );
					
						 clas.set(j+2, n[q.get(i).get(3)]);
						 j=j+2;
					}
			
			}
		}
						
			}
		}
		return clas;
}
}

		
