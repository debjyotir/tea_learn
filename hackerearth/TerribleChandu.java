import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;


class TerribleChandu {
    public static void main(String args[] ) throws java.lang.Exception {
        
        // Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            StringBuilder inp = new StringBuilder();
            inp.append(br.readLine());
            System.out.println(inp.reverse());
        }
    }
}
