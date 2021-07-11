package DynamicProg;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

public class IsMatchTest {
    public static void main(String[] args) {

    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sLen = s.length();
        int pLen = p.length();
        boolean [][] dp = new boolean[sLen+1][pLen=1];
        dp[0][0] = true;


        return false;
    }
}
