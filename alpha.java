package codechef;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            String c = "";
            List<Character> ll = new ArrayList<>();
           
            for (int i = 0; i < a.length(); i++) {
                ll.add(a.charAt(i));
            }
            for (int i = 0; i < b.length(); i++) {
                if (!ll.contains(b.charAt(i)))
                    c += b.charAt(i);
            }
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < c.length(); i++) {
                set.add(c.charAt(i));
            }
            List<Character> numbersList = new ArrayList<>(set);
            Collections.sort(numbersList);
            if (numbersList.size() >= 1) {
                for (int i = 0; i < numbersList.size(); i++) {
                    System.out.print(numbersList.get(i));
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }

        }
    }
}
