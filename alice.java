import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            int[][] queries = new int[Q][3];
            for(int i_queries = 0; i_queries < Q; i_queries++)
            {
            	String[] arr_queries = br.readLine().split(" ");
            	for(int j_queries = 0; j_queries < arr_queries.length; j_queries++)
            	{
            		queries[i_queries][j_queries] = Integer.parseInt(arr_queries[j_queries]);
            	}
            }

            long[] out_ = maxProduct(N, Q, A, queries);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
            	System.out.print("\n" + out_[i_out_]);
            }
            
            System.out.println();
            
         }

         wr.close();
         br.close();
    }
    static long[] maxProduct(int N, int Q, int[] A, int[][] queries){
       // Write your code here
        long[] result = {0};

        return result;
    
    }
}