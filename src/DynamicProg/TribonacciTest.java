package DynamicProg;

public class TribonacciTest {
    public int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        if (n == 0) return t0;
        if (n == 1) return t1;
        if (n == 2) return t2;
        int [] dp = new int[n+1];
        for(int i = 3;i<=n;i++) {
            dp[i] = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = dp[i];
        }
        return dp[n];
    }
}
