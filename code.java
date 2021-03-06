package codechef;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class code {
  static final int MOD = 998244353;
  static final Random RAND = new Random();
 
 
  static long solve(int n, int[][] edges, int[] queries) {
    int m = edges.length;
    int k = queries.length;
 
    
    Arrays.sort(queries);
  
 
    Arrays.sort(edges, (x,y)->x[2] - y[2]);
  
 
    TreeMap<Integer, long[]> cm = new TreeMap<>();
    for (int[] edge : edges) {
      int x = edge[2];
      long[] arr = getCost(n, edges, x);
      cm.put(x, arr);
      
    }
 
    
    {
      int v = cm.firstKey();
      if (v != 0) {
        long[] e0 = cm.get(v);
        cm.put(0, new long[] {e0[0] + e0[1] * (n-1), 0, 0, 0, n-1});
      }
      while (v != cm.lastKey()) {
        long[] curr = cm.get(v);
        long[] next = cm.ceilingEntry(v + 1).getValue();
        if (curr[2] + curr[3] == next[2] || curr[1] + 1 == next[1]) {
          v = (int)next[1];
        } else {
          int x = (int) ((curr[1] + next[1]) / 2);
          long[] arr = getCost(n, edges, x); 
          cm.put(x, arr);
        }
      }
    }
 
    long ans = 0;
    int ib = 0;
    while (ib < k) {
      int x = queries[ib];
      int ie = ib + 1;
      while (ie < k && queries[ie] == queries[ib]) {
        ie++;
      }
      if ((ie - ib) % 2 == 0) {
        ib = ie;
        continue;
      }
      ib = ie;
      long[] fe = cm.floorEntry(x).getValue();
      //  *       *        *        *        *        *
      //                   ^    ^   ^
      //                   fe   x  ce
      //  ------ fe[2] -- fe[3] ------ fe[4] ----------
      //  ----------ce[2] -------- ce[3] ---- ce[4] ---
      //
      int nl = (int) (fe[2] + fe[3]);
      int nr = (int) fe[4];
      long cost = fe[0] + (x - fe[1]) * (nl - nr);
      ans ^= cost;
    }
    return ans;
  }
 
  // Get [cost,x,#left,#on,#right] for x
  //      0    1 2     3   4
  private static long[] getCost(int n, int[][] edges, int x) {
    int m = edges.length;
    long[] ans = new long[5];
    ans[1] = x;
 
    UnionFind uf = new UnionFind(n);
    int i = 0;
    while (i < m && edges[i][2] <= x) {
      i++;
    }
    // b is the index in the low range with weight <= x
    int b = i - 1;
    // e is the index in the high range with weight > x
    int e = i;
 
    while (!uf.isSingleGroup()) {
      // Identify the edge to add
      int j = (b >= 0 && (e >= m || x - edges[b][2] <= edges[e][2] - x)) ? b : e;
      // System.out.format("    x:%d j:%d\n", x, j);
      int u = edges[j][0];
      int v = edges[j][1];
      int w = edges[j][2];
      if (uf.union(u, v)) {
        ans[0] += Math.abs(w - x);
        if (x == w) {
          ans[3]++;
        } else if (j == b) {
          ans[2]++;
        } else {
          ans[4]++;
        }
      }
      if (j == b) {
        b--;
      } else {
        e++;
      }
    }
    return ans;
  }
 
  static class UnionFind {
    int n;
    int m;  // number of groups
    int[] gids;
 
    public UnionFind(int n) {
      this.n = n;
      this.m = n;
      this.gids = new int[n];
      for (int i = 0; i < n; i++) {
        gids[i] = i;
      }
    }
 
    public boolean union(int i, int j) {
      int ri = find(i);
      int rj = find(j);
      if (ri != rj) {
        int id = Math.min(ri, rj);
        // Note that we must set gids[ri] instead of gids[i] etc
        gids[ri] = id;
        gids[rj] = id;
        m--;
        return true;
      }
      return false;
    }
 
    public int find(int i) {
      while (i != gids[i]) {
        gids[i] = gids[gids[i]];
        i = gids[i];
      }
      return i;
    }
 
    public boolean isSingleGroup() {
      return m == 1;
    }
 
    public void clear() {
      for (int i = 0; i < n; i++) {
        gids[i] = i;
      }
      this.m = n;
    }
  }
 
  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int r = RAND.nextInt(arr.length);
      int temp = arr[i];
      arr[i] = arr[r];
      arr[r] = temp;
    }
    Arrays.sort(arr);
  }
 
  static void doTest() {
    long t0 = System.currentTimeMillis();
    int n = 50;
    int m = 300;
    int k = 5000000;
    int c = 100000000;
    int[][] edges = generateEdges(n, m, c);
    // System.out.println(Utils.trace(edges));
    int[] queries = new int[k];
    for (int i = 0; i < k; i++) {
      queries[i] = RAND.nextInt(c - 1);
    }
    long ans = solve(n, edges, queries);
    // System.out.println(ans);
    System.out.format("%d msec\n", System.currentTimeMillis() - t0);
    System.exit(0);
  }
 
  // Generate m edges into a connected graph with n nodes and ids in [0,n-1]
  public static int[][] generateEdges(int n, int m, int c) {
    myAssert(n >= 2 && m >= n-1);
    int[][] edges = new int[m][3];
 
    // Firstly generate edges in a spanning tree
    List<Integer> used = new ArrayList<>();
    List<Integer> avai = new ArrayList<>();
    Random rand = new Random();
    int i0 = rand.nextInt(n);
    used.add(i0);
    for (int i = 0; i < n; i++) {
      if (i != i0) {
        avai.add(i);
      }
    }
    int idx = 0;
    while (!avai.isEmpty()) {
      edges[idx][0] = avai.remove(rand.nextInt(avai.size()));
      edges[idx][1] = used.get(rand.nextInt(used.size()));
      edges[idx][2] = rand.nextInt(c);
      used.add(edges[idx][0]);
      idx++;
    }
    // The add arbitrary extra edges
    while (idx < m) {
      edges[idx][0] = rand.nextInt(n);
      edges[idx][1] = rand.nextInt(n);
      edges[idx][2] = rand.nextInt(c);
      idx++;
    }
    return edges;
  }
 
  public static void main(String[] args) {
    // doTest();
    MyScanner in = new MyScanner();
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] edges = new int[m][3];
    for (int i = 0; i < m; i++) {
      edges[i][0] = in.nextInt() - 1;
      edges[i][1] = in.nextInt() - 1;
      edges[i][2] = in.nextInt();
    }
    int p = in.nextInt();
    int k = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int[] queries = new int[k];
    for (int i = 0; i < p; i++) {
      queries[i] = in.nextInt();
    }
    for (int i = p; i < k; i++) {
      queries[i] = (int) (((long)queries[i-1] * a + b) % c);
    }
 
    long ans = solve(n, edges, queries);
    System.out.println(ans);
  }
 
  static Scanner getInputScanner() {
    try {
      final String USERDIR = System.getProperty("user.dir");
      final String CNAME = MethodHandles.lookup().lookupClass().getSimpleName();
      final File fin = new File(USERDIR + "/io/c" + CNAME.substring(1,5) + "/" + CNAME + ".in");
      return fin.exists() ? new Scanner(fin) : new Scanner(System.in);
    } catch (Exception e) {
      return new Scanner(System.in);
    }
  }
 
  static void output(int[] a) {
    if (a == null) {
      System.out.println("-1");
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (int v : a) {
      sb.append(v);
      sb.append(' ');
      if (sb.length() > 500) {
        System.out.print(sb.toString());
        sb.setLength(0);
      }
    }
    System.out.println(sb.toString());
  }
 
  static void myAssert(boolean cond) {
    if (!cond) {
      throw new RuntimeException("Unexpected");
    }
  }
 
  static class MyScanner {
    BufferedReader br;
    StringTokenizer st;
 
    public MyScanner() {
      try {
        final String USERDIR = System.getProperty("user.dir");
        String cname = MethodHandles.lookup().lookupClass().getCanonicalName();
        // C1621C.MyIo -> C1621C
        int i = cname.lastIndexOf('.');
        if (i > 0) {
          cname = cname.substring(0, i);
        }
        final File fin = new File(USERDIR + "/io/c" + cname.substring(1,5) + "/" + cname + ".in");
        br = new BufferedReader(new InputStreamReader(fin.exists() ? new FileInputStream(fin) : System.in));
      } catch (Exception e) {
        br = new BufferedReader(new InputStreamReader(System.in));
      }
    }
 
    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
 
    public long nextLong() {
      return Long.parseLong(next());
    }
 
    public double nextDouble() {
      return Double.parseDouble(next());
    }
 
    public String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
