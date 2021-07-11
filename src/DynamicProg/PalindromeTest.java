package DynamicProg;

public class PalindromeTest {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));
    }

    /**
     *  x x x x x
     *  x x x x x
     *  x x x x x
     *  x x x x x
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 0;
        boolean[][] dp= new boolean[len][len];
        int start = 0;
//        for(int i = 0;i<len;i++) {
//            dp[i][i] = true;
//        }
        for(int j = 1;j<len;j++) {
            for(int i = 0;i<=j;i++) {
                if (i == j) {
                    dp[i][j] = true;
                }else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j-i+1 > maxLen) {
                    start = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
