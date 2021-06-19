public class BeibaoTest {
    public static void main(String[] args) {
        int[] weight = {1 ,3 ,4, 5};
        int[] value = {15, 20, 30, 12};
        int bagsize = 7;
        caculateMaxWeight(weight, value, bagsize);
        caculateMaxWeightPri(weight, value, bagsize);
    }

    public static void caculateMaxWeight(int[] w, int[] v, int bagsize) {
        int len = w.length;
        int[][] dp = new int[len+1][bagsize+1];
        for(int i = 0;i<=len;i++) { //初始化
            dp[i][0] = 0;
        }

        for(int i = 1;i<=len;i++) {
            for(int j = 1;j<=bagsize;j++) {
                if (j<w[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + v[i-1]);
                }
            }
        }

        System.out.println("Max value is : " + dp[len][bagsize]);
    }

    //滚动数组优化
    public static void caculateMaxWeightPri(int[] w, int[] v, int bagsize) {
        int len = w.length;
        int[] dp = new int[bagsize+1];
        for(int i = 0;i<=len;i++) { //选取0个物品
            dp[0] = 0;
        }

        for(int i = 0;i<w.length;i++) {
            for(int j = bagsize;j>=w[i];j--) { //注意等于时候的区别
                dp[j]=Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }

        System.out.println("Max value is : " + dp[bagsize]);
    }
}
